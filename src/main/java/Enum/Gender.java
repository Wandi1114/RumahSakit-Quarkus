package Enum;

public enum Gender {
    Pria {
        @Override
        public String toString() {
            return "Pria";
        }
    },
    Wanita {
        @Override
        public String toString() {
            return "Wanita";
        }
    },
    Other {
        @Override
        public String toString() {
            return "Other";
        }
    },
}
