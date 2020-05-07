package sprint11;

public class Sprint11Task3 {
    public static Sprint11Task2.Plant tryCreatePlant(String type, String color, String name) {
        try {
            return new Sprint11Task2.Plant(type, color, name);
        } catch (Sprint11Task2.ColorException e1) {
            return tryCreatePlant(type, Sprint11Task2.Color.Red.name(), name);
        } catch (Sprint11Task2.TypeException e2) {
            return tryCreatePlant(Sprint11Task2.Type.Ordinary.name(), color, name);
        }
    }
}
