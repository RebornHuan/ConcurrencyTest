
class Person{

private String name ;// 定义name属性

private int age ;// 定义age属性

public Person(String name,int age){

this.name = name ;

this.age = age ;

}

public boolean equals(Object obj){

if(this==obj){// 地址相等

return true ;// 肯定是同一个对象

}

if(!(obj instanceof Person)){// 不是Person对象

return false ;

}

Person per = (Person) obj ;// 向下转型

if(per.name.equals(this.name)&&per.age == this.age){

return true ;// 依次比较内容

}else{

return false ;

}

}

public String toString(){

return "姓名：" + this.name + "；年龄：" + this.age ;

}




public static void main(String args[]){

/*Person per1 = new Person("小峰老师",33) ; // 实例化Person

Person per2 = new Person("小峰老师",33) ; // 实例化Person

System.out.println(per1.equals(per2)?"是同一个人！" : "不是同一个人！") ;

System.out.println(per1.equals("hello")?"是同一个人！" : "不是同一个人！") ;*/
	String a=".wanghuan";
	  while (a.startsWith(".")) {
	        a=a.substring(1);
	        System.out.println(a);
	      }

}

};