package com.nextzy.nextzymvp.common.permission;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */

@Parcel
public class PermissionResult {
    List<Permission> permissionList;

    public PermissionResult() {
    }

    public PermissionResult(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public boolean areAllPermissionsGranted() {
        if (isPermissionListAvailable()) {
            for (Permission permission : permissionList) {
                if (permission.isDenied()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isAnyPermissionPermanentlyDenied() {
        if (isPermissionListAvailable()) {
            for (Permission permission : permissionList) {
                if (permission.isDenied()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean isPermissionListAvailable() {
        return permissionList != null && permissionList.size() > 0;
    }

    public List<Permission> getDeniedPermissionResponses() {
        List<Permission> deniedPermissionList = new ArrayList<>();
        if (isPermissionListAvailable()) {
            for (Permission permission : permissionList) {
                if (permission.isDenied()) {
                    deniedPermissionList.add(permission);
                }
            }
        }
        return deniedPermissionList;
    }

    public List<Permission> getGrantedPermissionResponses() {
        List<Permission> grantedPermissionList = new ArrayList<>();
        if (isPermissionListAvailable()) {
            for (Permission permission : permissionList) {
                if (permission.isGranted()) {
                    grantedPermissionList.add(permission);
                }
            }
        }
        return grantedPermissionList;
    }

    @Parcel
    public static class Permission {
        String permissionName;
        boolean isGranted;

        public Permission() {
        }

        public Permission(String permissionName, boolean isGranted) {
            this.permissionName = permissionName;
            this.isGranted = isGranted;
        }

        public String getPermissionName() {
            return permissionName;
        }

        public boolean isGranted() {
            return isGranted;
        }

        public boolean isDenied() {
            return !isGranted;
        }
    }
}
