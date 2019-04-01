package practice1;

import com.google.common.collect.ImmutableList;

public class Security {

    private SecurityChecker securityChecker;

    public Security(SecurityChecker checker) {
        this.securityChecker = checker;
    }

    public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {

        boolean isAccess = false;
        if ( userisNull(user) || permissionIsNull(permission) || permissionsSizeIsZero(permissions)){
            return isAccess;
        }

        if (securityChecker.isAdmin()) {
            isAccess = true;
        }

        if (this.securityChecker.checkPermission(user, permission) || permissions.contains(permission)) {
            isAccess = true;
        }

        return isAccess;
    }

    private boolean permissionsSizeIsZero(ImmutableList<Permission> permissions) {
        return permissions.size() == 0;
    }

    private boolean permissionIsNull(Permission permission) {
        return permission == null;
    }

    private boolean userisNull(User user) {
        return user == null;
    }
}
