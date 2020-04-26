package marshall_unmarshall_xml;

import javax.xml.bind.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class mainMarshallUnmarshall {
    public static void main(String[] args) throws Exception {

        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            File file = new File("src/test"+"\\fileMarshallXml.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(personsData(), file);
            jaxbMarshaller.marshal(personsData(), System.out);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //We had written this file in marshalling example
            System.out.println("\r\n unmarshalling \r\nPersons");
            Persons pers = (Persons) jaxbUnmarshaller.unmarshal( new File("src/test/fileMarshallXml.xml") );
            for(Person per : pers.getPersons()){
                System.out.println("Person");
                System.out.println("name: " + per.getName());
                System.out.println("birthday: " + sf.format(per.getBirthday()));
                if(!per.getHobbies().isEmpty()) {
                    for (Hobbies hobbs : per.getHobbies()) {
                        System.out.println("hobbies");
                        for (Hobby hob : hobbs.getHobby()) {
                            System.out.println("hobby");
                            System.out.println("complexity: " + hob.getComplexity());
                            System.out.println("hobby_name: " + hob.getHobbyName());
                        }
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static Persons personsData() throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        Persons personsData = new Persons();
        personsData.setPersons(new ArrayList<Person>());

        Person person1 = new Person();
        person1.setName("Ivanov Viacheslav Igorevich");
        person1.setBirthday(sf.parse("1994-09-09"));
        person1.setHobbies(new ArrayList<Hobbies>());
        Hobbies hobbiesPerson1 = new Hobbies();
        hobbiesPerson1.setHobby(new ArrayList<Hobby>());
        Hobby hobbyPerson1 = new Hobby();
        hobbyPerson1.setComplexity("10");
        hobbyPerson1.setHobbyName("Bycicle");
        hobbiesPerson1.getHobby().add(hobbyPerson1);
        person1.getHobbies().add(hobbiesPerson1);

        Person person2 = new Person();
        person2.setName("Fdafds Afcbfh Hhfgndfg");
        person2.setBirthday(sf.parse("1984-11-11"));
        person2.setHobbies(new ArrayList<Hobbies>());
        Hobbies hobbiesPerson2 = new Hobbies();
        hobbiesPerson2.setHobby(new ArrayList<Hobby>());
        Hobby hobby1Person2 = new Hobby();
        hobby1Person2.setComplexity("20");
        hobby1Person2.setHobbyName("Monocicle");
        Hobby hobby2Person2 = new Hobby();
        hobby2Person2.setComplexity("100");
        hobby2Person2.setHobbyName("Fourcicle");
        hobbiesPerson2.getHobby().add(hobby1Person2);
        hobbiesPerson2.getHobby().add(hobby2Person2);
        person2.getHobbies().add(hobbiesPerson2);

        Person person3 = new Person();
        person3.setName("Kkpobmhtg Bklbjierg Okjdvopv");
        person3.setBirthday(sf.parse("1974-12-12"));
        person3.setHobbies(new ArrayList<Hobbies>());
        Hobbies hobbiesPerson3 = new Hobbies();
        hobbiesPerson3.setHobby(new ArrayList<Hobby>());
        Hobby hobbyPerson3 = new Hobby();
        hobbyPerson3.setComplexity("30");
        hobbyPerson3.setHobbyName("Tricicle");
        hobbiesPerson3.getHobby().add(hobbyPerson3);
        person3.getHobbies().add(hobbiesPerson3);

        personsData.getPersons().add(person1);
        personsData.getPersons().add(person2);
        personsData.getPersons().add(person3);

        return personsData;
    }
}
