package com.designPatterns.Prototype;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Prototype
 * 模版浅克隆
 */
public class MailTempletReferenceClone implements Cloneable{

    private String subject;

    private String name;

    private String address;

    private Integer wordSize;

    private MailBag mailBag = new MailBag();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Integer getWordSize() {
        return wordSize;
    }

    public void setWordSize(Integer wordSize) {
        this.wordSize = wordSize;
    }

    public MailBag getMailBag() {
        return mailBag;
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


    public class MailBag{
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
    }
}
