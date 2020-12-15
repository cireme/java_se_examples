package object_manipulation.comparator;

import file_handling.model.Member;

import java.util.Comparator;

public class MemberLastNameComparator implements Comparator<Member> {
    @Override
    public int compare(Member o1, Member o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
