/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;



import DA.StaffDA;
import domain.Staff;


public class MaintainStaffControl {
    private StaffDA sfDA;
    
    public MaintainStaffControl() {
        sfDA = new StaffDA();
    }
    
    public Staff selectRecordID(String Sf_id) {
        return sfDA.getStaffRecordWithId(Sf_id);
    }
    
    public void addRecord(Staff staff) {
        sfDA.addOnNewMemberRecord(staff);
    }
    
    public void UpdateRecord(Staff staff) {
        sfDA.updateStaffRecord(staff);
    }
    
    public void DeleteRecord(Staff staff) {
        sfDA.deleteRecord(staff);
    }

}


