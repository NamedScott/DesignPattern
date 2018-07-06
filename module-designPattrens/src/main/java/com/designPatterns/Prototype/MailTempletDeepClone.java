package com.designPatterns.Prototype;

import java.io.IOException;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Prototype
 */
public class MailTempletDeepClone implements Cloneable {

    private String subject;

    private String name;

    private String address;

    private MailTempletDeepClone.MailBag mailBag = new MailTempletDeepClone.MailBag();

    @Override
    protected MailTempletDeepClone clone() throws CloneNotSupportedException {
        MailTempletDeepClone mailTempletDeepClone = (MailTempletDeepClone)super.clone();
        mailTempletDeepClone.mailBag  = (MailBag)this.mailBag.clone();
        return mailTempletDeepClone;
    }

       public MailTempletDeepClone.MailBag getMailBag() {
        return this.mailBag;
    }

    public void setMailBag(String bagName ,Integer bagSize) {
        this.mailBag.setBagName(bagName);
        this.mailBag.setBagSize(bagSize);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public class MailBag implements  Cloneable{
        private String bagName;
        private Integer bagSize;

        public String getBagName() {
            return bagName;
        }

        public void setBagName(String bagName) {
            this.bagName = bagName;
        }

        public Integer getBagSize() {
            return bagSize;
        }

        public void setBagSize(Integer bagSize) {
            this.bagSize = bagSize;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}
