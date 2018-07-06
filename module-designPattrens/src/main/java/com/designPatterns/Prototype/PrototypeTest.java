package com.designPatterns.Prototype;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Prototype
 */
public class PrototypeTest {


    /**
     * 浅复制-->其内部对象会只是引用克隆，被克隆对象内部对象改变后，克隆对象内部对象随之变化
     * @throws CloneNotSupportedException
     */
    @Test
    public void referenceCopyTest() throws CloneNotSupportedException {
        MailTempletReferenceClone mail = new MailTempletReferenceClone();
        mail.setName("严二狗");
        mail.setAddress("北京市海淀区");
        mail.setSubject("offer");
        mail.setMailBag("附件1",10);
        mail.setWordSize(222);
        MailTempletReferenceClone mail1 = (MailTempletReferenceClone)mail.clone();
        mail.setMailBag("附件2",20);
        mail.setWordSize(333);
        System.out.println(ToStringBuilder.reflectionToString(mail.getMailBag()));
        System.out.println(ToStringBuilder.reflectionToString(mail1.getMailBag()));
        System.out.println(mail.getWordSize());
        System.out.println(mail1.getWordSize());

    }

    /**
     * 深克隆-->其内部对象同时实现克隆，被克隆对象内部对象改变后，克隆对象内部对象不随之变化
     * @throws CloneNotSupportedException
     */
    @Test
    public void deepClone() throws CloneNotSupportedException {
        MailTempletDeepClone mail = new MailTempletDeepClone();
        mail.setName("严二狗");
        mail.setAddress("北京市海淀区");
        mail.setSubject("offer");
        mail.setMailBag("附件1",10);
        MailTempletDeepClone mail1 = mail.clone();
        mail.setMailBag("附件2",20);
        System.out.println(ToStringBuilder.reflectionToString(mail.getMailBag()));
        System.out.println(ToStringBuilder.reflectionToString(mail1.getMailBag()));
    }


}
