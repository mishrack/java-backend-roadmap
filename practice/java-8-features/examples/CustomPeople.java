package practice.streams.custom.people;

import java.util.*;
import java.util.stream.Collectors;

public class PeopleDemo {
        public static void main(String[] args) {
            List<People> list = getPeopleList();

            // Imperative approach  -- OLD approach
            List<People> femaleList = new ArrayList<>();
            for (People person : list){
                if(person.getGender().equals(Gender.FEMALE)){
                    femaleList.add(person);
                }
            }
    //        femaleList.forEach(people -> System.out.println(people));

            // Declarative Approach -- NEW approach
            // 1.Filter
            List<People> females = list.stream()
                    .filter(people -> people.getGender().equals(Gender.FEMALE))
                    .collect(Collectors.toList());
//            females.forEach(System.out::println);

            // 2.Sort  -- age reverse order / age and  gender
            List<People> sortedAgeList = list.stream()
                    .sorted(Comparator.comparing(People::getAge)
                            .thenComparing(Comparator.comparing(People::getGender)).reversed())
                    .collect(Collectors.toList());
//            sortedAgeList.forEach(System.out::println);


            // 3.AnyMatch / AllMatch / NoneMatch
            boolean allMatched = list.stream()
                    .allMatch(people -> people.getAge() > 25);
            boolean anyMatched = list.stream()
                    .anyMatch(people -> people.getAge() > 25);
            boolean noneMatched = list.stream()
                    .noneMatch(people -> people.getAge() > 25);

//            System.out.println("All matched case : " +allMatched);
//            System.out.println("Any matched case : " +anyMatched);
//            System.out.println("None matched case : " + noneMatched);

            // Max/Min
            list.stream()
                    .max(Comparator.comparing(People::getAge))
                    .ifPresent(System.out::println);
            list.stream()
                    .min(Comparator.comparing(People::getAge))
                    .ifPresent(System.out::println);

            // Group
            Map<Gender, List<People>> groupByGender = list.stream()
                    .collect(Collectors.groupingBy(People::getGender));

            groupByGender.forEach((gender, people1) ->{
                        System.out.println(gender);
                        people1.forEach(System.out::println);
                        }
                    );

            // filter/max amd map
            Optional<String> oldestFemal = list.stream()
                    .filter(people -> people.getGender().equals(Gender.FEMALE))
                    .max(Comparator.comparing(People::getAge))
                    .map(People::getName);
            oldestFemal.ifPresent(System.out::println);


        }

    private static List<People> getPeopleList(){
        return List.of(
                new People("ram",25,Gender.MALE),
                new People("shyam",22,Gender.MALE),
                new People("sita",24,Gender.FEMALE),
                new People("geeta",23,Gender.FEMALE),
                new People("ravi",27,Gender.MALE),
                new People("shakti",27,Gender.FEMALE)
        );
    }
}
