package file_handling.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Club implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private List<Member> members;

    public Club(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
        if(this.members == null) {
            this.members = new LinkedList<>();
        }

        this.members.add(member);
    }

    public void removeMember(int index) {
        this.members.remove(index);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
