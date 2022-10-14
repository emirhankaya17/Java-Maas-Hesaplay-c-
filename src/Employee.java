public class Employee {
    String name;
    float salary;
    int workHours,hireYear;

    public Employee(String name, float salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public float tax(){
        // Maaşa uygulanan vergiyi hesaplayacaktır.
        //Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
        //Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
        return salary < 1000 ? 0: salary * 3/100;

    }

    public float bonus(){
        // Eğer çalışan haftada 40 saatten fazla çalışmış
        // ise fazladan çalıştığı her saat başına 30 TL olacak şekilde
        // bonus ücretleri hesaplayacaktır.
        return workHours>40 ? (workHours-40)*30 : 0;
    }
    public float raiseSalary(){
        //Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
        float raiseAmount = 0;
        float tempSalary = salary - tax() + bonus();
        //Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
        //Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
        //Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.

        if(2021 - hireYear <10) raiseAmount = tempSalary * 5/100;
        else if(2021 - hireYear >19) raiseAmount = tempSalary * 15/100;
        else raiseAmount = tempSalary * 10/100;

        return  raiseAmount;

    }

    public String toString(){
        String text = "name: "+name+"\n"+
                "Base Salary: "+salary+"\n"+
                "Work Hours: "+workHours+"\n"+
                "Hire Year: "+hireYear+"\n"+
                "Tax: "+tax()+"\n"+
                "Bonus: "+bonus()+"\n"+
                "Combined Salary: "+(salary - tax() + bonus())+"\n"+
                "Salary Raise: "+raiseSalary()+" - New Salary: "+(salary - tax() + bonus() + raiseSalary())+"\n";
        System.out.println(text);
        return text;
    }


}


