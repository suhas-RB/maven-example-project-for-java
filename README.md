# maven-example-project-for-java
<a href="https://maven.apache.org" target="_blank" title="Maven site">Maven</a> is a software project management and comprehension tool, so in other words it can be used to manage all software cycle.
This software it helps me a lot in my works and personal projects and in this post I try to share some knownledge and information that I learned.

I create a simple project available that cover most of the maven lifecycle.
I hope it will help you on your job or personal project(s).

***
## How to build
In order to execute build my example you have two way:

  + **Maven CLI** (Command Line Interface). In this case you need to install maven see <a href="https://maven.apache.org/install.html" target="_blank" title="Maven install">here</a> for more details.
  Here the instruction:
    1. **Clone** git repository or **download** the maven project

    2. **Open** terminal or your prompt and **navigate to** maven example project (you must go inside the folder)

    3. **Execute** the following command: mvn clean install

    4. **Go** to "How To execute" in order to execute the program

  + **Eclipse** - The following instructions are tested for Eclipse Mars (version 4.5).

    1. **Clone** git repository or **download** the maven project

    2. **Start** eclipse

    3. **Import** maven project into eclipse by **select** _"File" &#8594; "Import..."_<br>

    4. **Write** "maven" in _"Select an import source"_ field, **select** _"Existing Maven Projects"_ and then **click** on _"Next >"_<br>

    5. **Browse** to the directory where you save the project and then **click** on _"Finish"_<br>

    6. **Click** with the right mouse button on the root project and **select** _"Run As" &#8594; "Maven build"_<br>

    7. **Write** "clean install" in _"Goals"_ input field, then **click** on "Apply" and finally **click** on "Run"<br>
       Note: If you want execute sonar, you will insert "sonar" in _"Profiles"_ input field.

    8. **Go** to "How To execute" in order to execute the program

***
## How to execute
1. **Open** terminal or your prompt and **navigate to** maven example project (you must go inside the folder)
2. **Execute** the following command (replace '/' with '\' if you are on windows environment): java -jar ./target/maven-example-project-for-java.jar

### **_Happy coding_ ;)**
