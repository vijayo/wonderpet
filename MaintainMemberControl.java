/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;



import DA.MemberDA;
import domain.Member;
public class MaintainMemberControl {
    private MemberDA memDA;
    
    
    public MaintainMemberControl() {
        memDA = new MemberDA();
    }
    
    public Member selectRecord(String Mem_id) {
        return memDA.getMemberRecordWithId(Mem_id);
    }

    public void addRecord(Member member) {
        memDA.addOnNewMemberRecord(member);
    }
    
    public void UpdateRecord(Member member) {
        memDA.updateMemberRecord(member);
    }
    
    public void DeleteRecord(Member member) {
        memDA.deleteMemberRecordWithId(member);
    }
    
}

