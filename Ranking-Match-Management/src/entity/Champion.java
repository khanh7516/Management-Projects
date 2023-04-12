package entity;

public class Champion {
        private String name;
        private String position;

        public Champion(String name, String position) {
            this.name = name;
            this.position = position;
        }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
