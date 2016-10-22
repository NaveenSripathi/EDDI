package io.sls.expressions;

import io.sls.utilities.CharacterUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * User: jarisch
 * Date: 10.12.2009
 * Time: 15:37:14
 */
public class Expression implements Cloneable {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String domain;
    protected String expressionName;
    protected List<Expression> subExpressions = new LinkedList<Expression>();

    protected Expression() {
    }

    public Expression(String expressionName) {
        this.expressionName = expressionName;
    }

    public Expression(String expressionName, Expression... subExpressions) {
        this(expressionName);
        Collections.addAll(this.subExpressions, subExpressions);
    }

    public Expression(String expressionName, List<Expression> subExpressions) {
        this(expressionName);
        this.subExpressions = subExpressions;
    }

    public String getExpressionName() {
        return expressionName;
    }

    public void setExpressionName(String expressionName) {
        int dot = expressionName.indexOf(".");
        if (dot == -1 || CharacterUtilities.isNumber(expressionName, false))
            this.expressionName = expressionName;
        else if (dot == 0)
            this.expressionName = expressionName.substring(1, expressionName.length());
        else {
            this.domain = expressionName.substring(0, dot);
            this.expressionName = expressionName.substring(dot + 1, expressionName.length());
        }
    }

    public Expression[] getSubExpressions() {
        return subExpressions.toArray(new Expression[subExpressions.size()]);
    }

    public List<Expression> getSubExpressionsAsList() {
        return Collections.unmodifiableList(subExpressions);
    }

    public void setSubExpressions(Expression... subExpressions) {
        this.subExpressions = new LinkedList<>();
        Collections.addAll(this.subExpressions, subExpressions);
    }

    public void setSubExpressions(List<Expression> subExpressions) {
        this.subExpressions = subExpressions;
    }

    public void setSubExpression(int index, Expression subExpression) {
        if (index < 0 || index >= this.subExpressions.size()) {
            logger.error("Tried to set a subexpression out of bounds!");
            return;
        }

        this.subExpressions.set(index, subExpression);
    }

    public void addSubExpressions(Expression... subExpressions) {
        List<Expression> subExpsList = new LinkedList<Expression>();
        Collections.addAll(subExpsList, subExpressions);
        this.subExpressions.addAll(subExpsList);
    }

    public void addSubExpressions(int index, Expression... subExpressions) {
        if (index < 0 || index > this.subExpressions.size()) {
            logger.error("Tried to set a subexpression out of bounds!");
            return;
        }

        List<Expression> subExpsList = new LinkedList<Expression>();
        Collections.addAll(subExpsList, subExpressions);
        this.subExpressions.addAll(index, subExpsList);
    }

    public void addSubExpressions(List<Expression> subExpressions) {
        this.subExpressions.addAll(subExpressions);
    }

    public void removeSubExpressions(Expression... subExpressions) {
        for (Expression exp : subExpressions) {
            this.subExpressions.remove(exp);
        }
    }

    public void removeSubExpression(Integer index) {
        if (index > this.subExpressions.size())
            return;

        Expression expToRemove = this.subExpressions.get(index);
        removeSubExpressions(expToRemove);
    }

    public void clearSubExpressions() {
        this.subExpressions.clear();
    }

    // needs to be overridden by subclasses

    public boolean isExpressionSubCategory() {
        return false;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getFullExpression() {
        return domain + "." + expressionName;
    }

    public boolean canBeConnected(Expression exp) {
        return getDomain() == null || getDomain().equals(exp.getDomain());
    }


    public Boolean containsExpressionWithName(String expressionName) {
        return getAllExpressionsWithNames(expressionName).size() > 0;
    }

    /**
     * Returns a list of expressions that have the given expressionName.
     *
     * @param expressionNames
     * @return list of expressions matching of of the expression names of the param
     */
    public List<Expression> getAllExpressionsWithNames(String... expressionNames) {
        List<Expression> result = new ArrayList<Expression>();
        for (String expressionName : expressionNames) {
            if (getExpressionName().equals(expressionName)) {
                result.add(this);
            }

            if (this.getSubExpressions().length != 0) {
                for (Expression subExp : getSubExpressions())
                    result.addAll(subExp.getAllExpressionsWithNames(expressionName));
            }
        }

        return result;
    }

    public Expression safeClone() {
        try {
            Object clone = this.clone();
            return (Expression) clone;
        } catch (CloneNotSupportedException e) {
            logger.error("Cloning error!", e);
        }
        return null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Expression ret = (Expression) super.clone();
        LinkedList<Expression> tmp = new LinkedList<Expression>();

        for (Expression exp : subExpressions) {
            Expression subExpClone = (Expression) exp.clone();
            tmp.add(subExpClone);
        }

        ret.subExpressions = tmp;

        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;

        Expression that = (Expression) o;

        return expressionName.equals("*") || that.getExpressionName().equals("*") ||
                (expressionName.equals(that.getExpressionName()) && getSubExpressions().length == that.getSubExpressions().length &&
                        Arrays.equals(getSubExpressions(), that.getSubExpressions()));
    }

    @Override
    public int hashCode() {
        int result = (expressionName != null ? expressionName.hashCode() : 0);
        for (Expression e : getSubExpressions()) {
            result = 31 * result + (e != null ? e.hashCode() : 0);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        if (domain != null) {
            ret.append(domain).append(".");
        }

        ret.append(expressionName);

        if (!subExpressions.isEmpty()) {
            ret.append("(");

            for (Expression subExp : subExpressions) {
                ret.append(subExp).append(", ");
            }

            ret.deleteCharAt(ret.length() - 1);
            ret.deleteCharAt(ret.length() - 1);

            ret.append(")");
        }

        return ret.toString();
    }

    public String getGUIString() {
        StringBuilder ret = new StringBuilder();
        for (Expression subExp : subExpressions) {
            ret.append(subExp.getGUIString());
        }
        return ret.toString();
    }
}
