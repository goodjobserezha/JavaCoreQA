package HomeWork4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private final Map<Long, String> phoneNumbers;

    public PhoneBook() {
        this.phoneNumbers = new HashMap<>();
    }

    public void add (Long number, String lastName){
        phoneNumbers.put(number, lastName);
    }

    public List<PhoneNumber> get (String lastName){
        List<PhoneNumber> result = new ArrayList<>();
        for (Long number : phoneNumbers.keySet()) {
            if (phoneNumbers.get(number).equals(lastName)){
                result.add(new PhoneNumber(number, lastName));
            }
        }
        return result;
    }
}
