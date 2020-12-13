package object_manipulation.comparator;

import file_handling.model.Member;

import java.util.Comparator;

public class MemberIdComparator implements Comparator<Member> {

    @Override
    public int compare(Member o1, Member o2) {
        if(o1.getId() < o2.getId()) {
            return -1;
        }

        if (o1.getId().equals(o2.getId())) {
            return 0;
        }

        return 1;
    }

}
