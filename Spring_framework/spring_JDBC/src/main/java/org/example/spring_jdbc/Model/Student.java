package org.example.spring_jdbc.Model;


import org.springframework.stereotype.Component;

@Component
public class Student {

        private int id;
        private String name;
        private String feild;

        @Override
        public String toString() {
                return "Student{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", feild='" + feild + '\'' +
                        '}';
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getFeild() {
                return feild;
        }

        public void setFeild(String feild) {
                this.feild = feild;
        }
}
