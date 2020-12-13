package object_manipulation.service;

import file_handling.model.Member;
import object_manipulation.comparator.MemberFirstNameComparator;
import object_manipulation.comparator.MemberIdComparator;
import object_manipulation.comparator.MemberLastNameComparator;

import java.util.*;

public class ObjectService {

    public ObjectService() {
        this.run();
    }

    private void run() {
//        memberToString();
//        testEquals();
        testComparators();
    }

    public void memberToString() {
        Member member = new Member("Emeric", "Stophe", new Date());
        System.out.println(member.toString());
        System.out.println(member); // calls .toString()
    }

    public void testEquals() {
        Member member = new Member(1L, "Emeric", "Stophe", new Date());
        Member member2 = new Member(1L, "Emeric", "Stophe", new Date());

        System.out.println(member.equals(member2));
    }

    public void testComparators() {
        // simple compare()
        String a = "a";
        String b = "b";
        String secondB = "b";

        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        System.out.println(b.compareTo(secondB));

        Integer one = 1;
        Integer two = 2;
        Integer anotherOne = 1;

        System.out.println(one.compareTo(two));
        System.out.println(two.compareTo(one));
        System.out.println(one.compareTo(anotherOne));

        List<Member> members = getMembers();

        printMembers(members);
        printLine();

        // use compareTo()
        Collections.sort(members);

        // use Comparator<T>
        Collections.sort(members, new MemberIdComparator());

        printMembers(members);
        printLine();

        Collections.sort(members, new MemberFirstNameComparator());

        printMembers(members);
        printLine();

        Collections.sort(members, new MemberLastNameComparator());

        printMembers(members);

        // equals simplifies List uses
        Member memberToRemove = new Member(4L);

        if (members.contains(memberToRemove)) {
            System.out.println("Oh my god !! Mick is here !!");
        }

        System.out.println(members);

        System.out.println("See you Mick ;)");
        members.remove(memberToRemove);

        System.out.println(members);

        if (!members.contains(memberToRemove)) {
            System.out.println("Mick is not here anymore...");
        }

    }

    private void printMembers(List<Member> members) {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    private void printLine() {
        System.out.println("-----------------------------");
    }


    private List<Member> getMembers() {
        // comparator
        Member emeric = new Member(2L, "Emeric", "Stophe", new Date());
        Member john = new Member(1L, "John", "Doe", new Date());
        Member jane = new Member(3L, "Jane", "Doe", new Date());
        Member mick = new Member(4L, "Mick", "Jagger", new Date());

        return new LinkedList<>(Arrays.asList(emeric, john, mick, jane));
    }
}
