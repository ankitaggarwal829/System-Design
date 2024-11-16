package commons;

import Models.Doctor;
import Models.Slots;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {

    public static final String WELCOME_DR_GREETINGS = "Welcome Dr. ";
    public static final String DONE_DOC = "Done Doc!";
    public static  Map<Integer,Slots> bookingMap = new HashMap<>();
    
    public static Integer slotIndex = 1;
    public static Map<String, Map<String,List<Slots>>> specialityMap = new HashMap<>();

    public static Map<String, Doctor> doctorMap = new HashMap<>();

    public  static Map<String, List<Integer>> patientsMap = new HashMap<>();
}
