package Endpoints;

import Models.Doctor;
import Models.Slots;
import commons.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocActions {

    public void registerDoc( String name, String speciality){
        Doctor doc = new Doctor(name,speciality);
        Constants.doctorMap.put(name,doc);
        Map<String,List<Slots>> docList = null;
        if(Constants.specialityMap.containsKey(speciality)) {
            docList = Constants.specialityMap.get(speciality);
        }
        else{
            docList = new HashMap<>();
        }
        docList.put(name,new ArrayList<>());
        Constants.specialityMap.put(speciality,docList);
        System.out.println(Constants.WELCOME_DR_GREETINGS + name + " !!");
    }

    public void markDocAvail(String name, int stHr, int stMin, int enHr, int enMin){
        int duration = (((enHr*60) + enMin) - ((stHr*60) + stMin));
        if(duration!=60) {
            System.out.println("Sorry Dr. " + name + " slots are 60 mins only");
            return;
        }
        Slots slot = new Slots(stHr,stMin,null,name);
   //     Constants.slotsMap.put(Constants.slotIndex,slot);

        //find the position of slot to be inserted and updated it.
        Doctor docObj = Constants.doctorMap.get(name);
        Map<String, List<Slots>> specMap = Constants.specialityMap.get(docObj.getSpeciality());
        List<Slots> docSlots = specMap.get(name);
        docSlots.add(slot);
        specMap.put(name,docSlots);
        Constants.specialityMap.put(docObj.getSpeciality(), specMap);
        System.out.println(Constants.DONE_DOC);
    }


    public void showAvailByspeciality(String speciality){
        List<Slots> resList = new ArrayList<>();
        Map<String, List<Slots>> spMap =  Constants.specialityMap.get(speciality);
        for(Map.Entry<String, List<Slots>> entry: spMap.entrySet()){
            List<Slots> ls = entry.getValue();
            ls = ls.stream().filter((obj) -> obj.getEmpty()).toList();
            resList.addAll(ls);
        }
        for(Slots slot: resList){
            System.out.println("Dr."+ slot.getDocName()+ ": ("
                    +slot.getsHours()+":"+slot.getsMin()+"-"+(slot.getsHours()+1)+":"+((slot.getsMin()+60)%60)+")");
        }
    }

    public void registerPatient(String name){
        if(Constants.patientsMap.containsKey(name)){
            System.out.println("Mr. "+ name + " are already registered");
        }else{
            Constants.patientsMap.put(name, new ArrayList<>());
            System.out.println(name + " registered successfully");
        }
    }

    public void bookAppointment(String pName, String docName, int stHrs, int stMin){
        Doctor doc = Constants.doctorMap.get(docName);
        Map<String, List<Slots>> spMap = Constants.specialityMap.get(doc.getSpeciality());
        List<Slots> docSlot = spMap.get(docName);
        int id=-1;
        for(Slots slot : docSlot){
            if(slot.getsHours() ==  stHrs && slot.getsMin() == stMin){
                if(slot.getEmpty()){
                    slot.setEmpty(false);
                    slot.setpName(pName);
                    id = slot.getSlotIndex();
                    Constants.bookingMap.put(id,slot);
                    System.out.println("Booked. Booking id: "+id);
                    return;
                }else {
                    System.out.println("Slot occupied by " + slot.getpName());
                    return;
                }
            }
        }
        System.out.println("No such slot available");
        return;
//        spMap.put(docName,docSlot);
//        Constants.specialityMap.put(doc.getSpeciality(),spMap);
//
//        System.out.println("Booked. Booking id: "+id);
    }

    public void cancelBookingId(int id){
        if(Constants.bookingMap.containsKey(id)){
            Slots slot = Constants.bookingMap.get(id);
            Map<String, List<Slots>> spMap = Constants.specialityMap.get(Constants.doctorMap.get(slot.getDocName()).getSpeciality());
            List<Slots> docSlot = spMap.get(slot.getDocName());
            for(Slots slotObj : docSlot) {
                if(slotObj == slot){
                    slotObj.setEmpty(true);
                    Constants.bookingMap.remove(id);
                    System.out.println("Booking Cancelled");
                    return;
                }
            }
            System.out.println("No slot matches with "+ id);
        }else{
            System.out.println("No booking found with id:"+ id);
        }
    }
}
