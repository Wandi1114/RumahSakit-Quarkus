package Enum;

public enum ObatKategori {
    Syrup {
        public String toString() {
            return "Syrup";
        }
    },
    Pil {
        public String toString() {
            return "Pil";
        }
    },
    Tablet {
        public String toString() {
            return "Tablet";
        }
    },
    Cair {
        public String toString() {
            return "Cair";
        }
    },
    Other {
        public String toString() {
            return "Other";
        }
    }
}
