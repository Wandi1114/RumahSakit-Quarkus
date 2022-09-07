package Enum;

public enum Hari {
    senin {
        @Override
        public String toString() {
            return "senin";
        }
    },
    selasa {
        @Override
        public String toString() {
            return "selasa";
        }
    },
    rabu {
        @Override
        public String toString() {
            return "rabu";
        }
    },
    kamis {
        @Override
        public String toString() {
            return "kamis";
        }
    },
    jumat {
        @Override
        public String toString() {
            return "jumat";
        }
    },
    sabtu {
        @Override
        public String toString() {
            return "sabtu";
        }
    },
    minggu {
        @Override
        public String toString() {
            return "minggu";
        }
    }
}
