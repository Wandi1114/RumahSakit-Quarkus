package Enum;

public enum Posisi {
    Security {
        @Override
        public String toString() {
            return "Security";
        }
    },
    Janitor {
        @Override
        public String toString() {
            return "Janitor";
        }
    },
    Receipt {
        @Override
        public String toString() {
            return "Receipt";
        }
    },
    Engineer {
        @Override
        public String toString() {
            return "Engineer";
        }
    },

}
