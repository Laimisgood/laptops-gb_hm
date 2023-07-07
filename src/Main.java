import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = createLaptopSet();
        Map<Integer, String> filterCriteria = createFilterCriteria();
        Map<Integer, Object> filterParameters = requestFilterParameters(filterCriteria);
        Set<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria, filterParameters);

        System.out.println("Filter results:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println("Model: " + laptop.getModel());
            System.out.println("RAM: " + laptop.getRAM() + " GB");
            System.out.println("Hard Drive Capacity: " + laptop.getHardDriveCapacity() + " GB");
            System.out.println("Operating System: " + laptop.getOperatingSystem());
            System.out.println("Color: " + laptop.getColor());
            System.out.println("-------------------------------------");
        }
    }

    private static Set<Laptop> createLaptopSet() {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("Laptop 1", 8, 512, "Windows 10", "Gray"));
        laptops.add(new Laptop("Laptop 2", 16, 1024, "Windows 11", "Black"));
        laptops.add(new Laptop("Laptop 3", 8, 256, "Ubuntu", "White"));

        return laptops;
    }

    private static Map<Integer, String> createFilterCriteria() {
        Map<Integer, String> filterCriteria = new HashMap<>();

        filterCriteria.put(1, "RAM");
        filterCriteria.put(2, "Hard Drive Capacity");
        filterCriteria.put(3, "Operating System");
        filterCriteria.put(4, "Color");

        return filterCriteria;
    }

    private static Map<Integer, Object> requestFilterParameters(Map<Integer, String> filterCriteria) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> filterParameters = new HashMap<>();

        for (Integer criterion : filterCriteria.keySet()) {
            System.out.print("Enter a value for criterion '" + filterCriteria.get(criterion) + "': ");
            Object value = scanner.nextLine();
            filterParameters.put(criterion, value);
        }

        return filterParameters;
    }

    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<Integer, String> filterCriteria, Map<Integer, Object> filterParameters) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean matchesFilter = true;

            for (Integer criterion : filterCriteria.keySet()) {
                String filterCriterion = filterCriteria.get(criterion);
                Object filterParameter = filterParameters.get(criterion);

                switch (criterion) {
                    case 1:
                        int ram = Integer.parseInt((String) filterParameter);
                        if (laptop.getRAM() < ram) {
                            matchesFilter = false;
                        }
                        break;
                    case 2:
                        int hardDriveCapacity = Integer.parseInt((String) filterParameter);
                        if (laptop.getHardDriveCapacity() < hardDriveCapacity) {
                            matchesFilter = false;
                        }
                        break;
                    case 3:
                        String operatingSystem = (String) filterParameter;
                        if (!laptop.getOperatingSystem().equalsIgnoreCase(operatingSystem)) {
                            matchesFilter = false;
                        }
                        break;
                    case 4:
                        String color = (String) filterParameter;
                        if (!laptop.getColor().equalsIgnoreCase(color)) {
                            matchesFilter = false;
                        }
                        break;
                    default:
                        break;
                }

                if (!matchesFilter) {
                    break;
                }
            }

            if (matchesFilter) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }
}
