package base;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by scott on 2018/6/15.
 */
public class CollectionCompareTest {


    @Test
    public void listComparatorTest(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("blade",20,3000));
        userList.add(new User("alice",19,2700));
        userList.add(new User("alice",18,2500));
        userList.add(new User("scott",25,4000));
        Collections.sort(userList,new UserNameSort());
        userList.forEach(user->{ System.out.println(ToStringBuilder.reflectionToString(user)); });

    }


    private class UserNameSort implements  Comparator<User>{

        public int compare(User userA, User userB) {
            int i = userA.name.compareTo(userB.name);
            if(0 == i){
                i = userA.age.compareTo(userB.age);
            }
            return  i ;
        }
    }


    private  class User {

        private Integer age ;

        private String name;

        private long money;

        public User (String name ,Integer age ,long money){
            this.name = name ; this.age = age ; this.money = money;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getMoney() {
            return money;
        }

        public void setMoney(long money) {
            this.money = money;
        }

    }

}
