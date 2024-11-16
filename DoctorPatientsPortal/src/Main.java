
//i:registerDoc -> Curious-> Cardiologist
//o: Welcome Dr. Curious !!
//i: markDocAvail: Curious 9:00-10:30
//o: Sorry Dr. Curious slots are 60 mins only
//i: markDocAvail: Curious 9:00-10:00, 12:00-13:00, 16:00-17:00
//o: Done Doc!
//i:registerDoc -> Dreadful-> Dermatologist
//o: Welcome Dr. Dreadful !!
//i: markDocAvail: Dreadful 9:00-10:00, 11:00-12:00, 13:00-14:00
//o: Done Doc!
//i: showAvailByspeciality: Cardiologist
//o: Dr.Curious: (9:00-10:00)
//o: Dr.Curious: (12:00-13:00)
//o: Dr.Curious: (16:00-17:00)
//i: registerPatient ->PatientA
//o: PatientA registered successfully.
//i: bookAppointment: (PatientA, Dr.Curious, 12:00)
//O: Booked. Booking id: 1234
//i:showAvailByspeciality: Cardiologist
//o: Dr.Curious: (9:00-10:00)
//o: Dr.Curious: (16:00-17:00)
//i: cancelBookingId: 1234
//o: Booking Cancelled
//i: showAvailByspeciality: Cardiologist
//o: Dr.Curious: (9:00-10:

import Endpoints.DocActions;

public class Main {

    public static void main(String[] args) {
        DocActions fun = new DocActions();
        System.out.println("Hello world!");
        fun.registerDoc("Curious", "Cardiologist");
        fun.markDocAvail("Curious",9,0,10,30);
        fun.markDocAvail("Curious",9,0,10,0);
        fun.markDocAvail("Curious",12,0,13,0);
        fun.markDocAvail("Curious",16,0,17,0);
        fun.registerDoc("Dreadful", "Dermatologist");
        fun.markDocAvail("Dreadful",9,0,10,0);
        fun.markDocAvail("Dreadful",11,0,12,0);

        fun.markDocAvail("Dreadful",13,0,14,0);
        fun.showAvailByspeciality("Cardiologist");
        fun.registerPatient("PatientA");
        fun.bookAppointment("PatientA", "Curious", 12,0);
        fun.showAvailByspeciality("Cardiologist");
        fun.cancelBookingId(2);
        fun.showAvailByspeciality("Cardiologist");

        fun.bookAppointment("PatientB", "Curious", 12,0);

        fun.registerDoc("Daring", "Dermatologist");

        fun.markDocAvail("Daring",11,0,12,0);
        fun.markDocAvail("Daring",14,0,15,0);
        fun.showAvailByspeciality("Dermatologist");
        fun.bookAppointment("PatientF", "Daring", 11,0);
        fun.bookAppointment("PatientA", "Curious", 12,0);
        fun.bookAppointment("PatientF", "Curious", 9,0);
        fun.bookAppointment("PatientC", "Curious", 16,0);
        fun.showAvailByspeciality("Cardiologist");

        fun.bookAppointment("PatientC", "Curious", 16,0);
        fun.cancelBookingId(5);
  //      fun.showAppointmentsBooked("PatientF");

    }
}