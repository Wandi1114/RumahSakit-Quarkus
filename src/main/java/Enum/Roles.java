package Enum;

public enum Roles {
    superadmin {
        @Override
        public String toString() {
            return "superadmin";
        }
    },
    admin {
        @Override
        public String toString() {
            return "admin";
        }
    },
    user {
        @Override
        public String toString() {
            return "user";
        }
    }
}
