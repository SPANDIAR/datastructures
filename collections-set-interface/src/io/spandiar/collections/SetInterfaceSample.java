package io.spandiar.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetInterfaceSample {
	
	private String familyMember;
	private String memberName;
	private int age;
	


	@Override
	public String toString() {
		return "SetInterfaceSample [familyMember=" + familyMember + ", memberName=" + memberName + ", age=" + age + "]";
	}


	public SetInterfaceSample(String familyMember, String memberName, int age) {
		super();
		this.familyMember = familyMember;
		this.memberName = memberName;
		this.age = age;
	}


	public String getFamilyMember() {
		return familyMember;
	}


	public void setFamilyMember(String familyMember) {
		this.familyMember = familyMember;
	}


	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public static void main(String[] args) {
		
		SetInterfaceSample dad = new SetInterfaceSample("dad", "Pandiarajan", 73);
		SetInterfaceSample mom = new SetInterfaceSample("mom", "Eswari", 68);
		SetInterfaceSample me = new SetInterfaceSample("me", "Shankee", 38);
		SetInterfaceSample wifey = new SetInterfaceSample("wifey", "Karthika", 33);
		SetInterfaceSample kid = new SetInterfaceSample("kid", "Tannu", 7);
		SetInterfaceSample myClone = me;
		
		List<SetInterfaceSample> familyList = new ArrayList<>();
		Set<SetInterfaceSample> familySet = new HashSet<>();
		
		familyList = Arrays.asList(me, dad, mom, kid, wifey, myClone);
		familySet.addAll(familyList);
		
		System.out.println("Lets check");
		
		Comparator<SetInterfaceSample> memberAge = Comparator.comparing(SetInterfaceSample::getAge).reversed();
		
//		for(SetInterfaceSample member: familyList) {
//			System.out.println(member.getMemberName());
//		}
		
//		System.out.println("Sorted List");
//		
//		System.out.println(familyList.stream().sorted(memberAge).collect(Collectors.toList()));
//		
		
		for(SetInterfaceSample member: familySet) {
			System.out.println(member.getMemberName());
		}
		
//		System.out.println("Sorted Set");
//		
//		System.out.println(familySet.stream().sorted(memberAge).collect(Collectors.toList()));

	}

}
