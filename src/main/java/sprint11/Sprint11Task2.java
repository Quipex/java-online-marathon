package sprint11;

public class Sprint11Task2 {
    public static class Plant {
        private String name;
        private Color color;
        private Type type;

        public Plant(String type, String color, String name) throws ColorException, TypeException {
            this.name = name;
            try {
                this.color = Color.valueOf(color);
            } catch (IllegalArgumentException e) {
                throw new ColorException("No such color: " + color);
            }
            try {
                this.type = Type.valueOf(type);
            } catch (IllegalArgumentException e) {
                throw new TypeException("No such type: " + type);
            }
        }

        @Override
        public String toString() {
            return "{type: " + type.name() + ", color: " + color.name() + ", name: " + name + "}";
        }
    }

    enum Color {
        White, Red, Blue
    }

    enum Type {
        Rare, Ordinary
    }

    static class ColorException extends Exception {
        public ColorException(String message) {
            super(message);
        }
    }

    static class TypeException extends Exception {
        public TypeException(String message) {
            super(message);
        }
    }
}
