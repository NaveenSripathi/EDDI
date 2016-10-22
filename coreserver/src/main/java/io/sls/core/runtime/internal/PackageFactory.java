package io.sls.core.runtime.internal;

import io.sls.core.runtime.IExecutablePackage;
import io.sls.core.runtime.IPackageFactory;
import io.sls.core.runtime.client.packages.IPackageStoreClientLibrary;
import io.sls.core.runtime.service.ServiceException;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: jarisch
 * Date: 09.06.12
 * Time: 17:46
 */
public class PackageFactory implements IPackageFactory {
    private final Map<PackageId, IExecutablePackage> executablePackages = new ConcurrentHashMap<>();
    private final IPackageStoreClientLibrary packageStoreClientLibrary;

    @Inject
    public PackageFactory(IPackageStoreClientLibrary packageStoreClientLibrary) {
        this.packageStoreClientLibrary = packageStoreClientLibrary;
    }

    @Override
    public IExecutablePackage getExecutablePackage(final String packageId, final Integer packageVersion) throws ServiceException {
        PackageId id = new PackageId(packageId, packageVersion);
        if (!executablePackages.containsKey(id)) {
            synchronized (executablePackages) {
                IExecutablePackage executablePackage = packageStoreClientLibrary.getExecutablePackage(packageId, packageVersion);
                executablePackages.put(id, executablePackage);
            }
        }

        return executablePackages.get(id);
    }

    @Getter
    @Setter
    private class PackageId {
        private String id;
        private Integer version;

        private PackageId(String id, Integer version) {
            this.id = id;
            this.version = version;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PackageId packageId = (PackageId) o;

            return id.equals(packageId.id) && version.equals(packageId.version);

        }

        @Override
        public int hashCode() {
            int result = (id != null ? id.hashCode() : 0);
            result = 31 * result + (version != null ? version.hashCode() : 0);
            return result;
        }
    }
}
