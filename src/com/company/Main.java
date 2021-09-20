package com.company;

public class Main {

    static Fork fork1 = new Fork();
    static Fork fork2 = new Fork();
    static Fork fork3 = new Fork();
    static Fork fork4 = new Fork();
    static Fork fork5 = new Fork();

    public static void main(String[] args) {
        new Philosoph("1").start();
        new Philosoph("2").start();
        new Philosoph("3").start();
        new Philosoph("4").start();
        new Philosoph("5").start();
    }
    static class Philosoph extends Thread{
        private int forks = 0;
        public boolean equals(Object obj){
            return obj.hashCode() == this.hashCode();
        }
        public Philosoph(String name){
            super(name);
        }
        private boolean hasTwoForks(){
            if(forks == 2){
                if(fork1.getOwner() == this)
                    fork1.setOwner(null);
                if(fork2.getOwner() == this)
                    fork2.setOwner(null);
                if(fork3.getOwner() == this)
                    fork3.setOwner(null);
                if(fork4.getOwner() == this)
                    fork4.setOwner(null);
                if(fork5.getOwner() == this)
                    fork5.setOwner(null);
                return true;
            }
            return false;
        }
        public void run(){
            System.out.println("Running Philosoph: " + this.getName());
            while(true){
                if(fork1.getOwner() == null){
                    fork1.setOwner(this);
                    forks++;
                    if(hasTwoForks()){
                        break;
                    }
                }
                if(fork2.getOwner() == null){
                    fork2.setOwner(this);
                    forks++;
                    if(hasTwoForks()){
                        break;
                    }
                }
                if(fork3.getOwner() == null){
                    fork3.setOwner(this);
                    forks++;
                    if(hasTwoForks()){
                        break;
                    }
                }
                if(fork4.getOwner() == null){
                    fork4.setOwner(this);
                    forks++;
                    if(hasTwoForks()){
                        break;
                    }
                }
                if(fork5.getOwner() == null){
                    fork5.setOwner(this);
                    forks++;
                    if(hasTwoForks()){
                        break;
                    }
                }
            }
            System.out.println("Philosoph " + this.getName() + " is done.");
        }
    }
    static class Fork{
        private Philosoph owner;
        public void setOwner(Philosoph owner){
            this.owner = owner;
        }
        public Philosoph getOwner(){
            return owner;
        }
    }
}
