package Enum;

public enum RuangInapKategori {
    VIP {
        @Override
        public String toString() {
            return "VIP";
        }
    },
    VVIP {
        @Override
        public String toString() {
            return "VVIP";
        }
    },
}