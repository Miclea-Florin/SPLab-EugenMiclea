package com.example.splabeugenmiclea;

//import com.example.splabeugenmiclea.Classes.*;
//import com.example.splabeugenmiclea.Classes.models.Section;
import com.example.splabeugenmiclea.Classes.difexample.ClientComponent;
import com.example.splabeugenmiclea.Classes.difexample.SingletonComponent;
import com.example.splabeugenmiclea.Classes.difexample.TransientComponent;

import com.example.splabeugenmiclea.Classes.models.*;
import com.example.splabeugenmiclea.Classes.service.Visitor;
import com.example.splabeugenmiclea.Classes.service.implementation.RenderContentVisitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class SpLabEugenMicleaApplication {


        public static void createTableOfContent() {
            Book b = new Book("The book");
            Section cap1 = new Section("Chapter 1");
            Section cap11 = new Section("Subchapter 1.1");
            Section cap2 = new Section("Chapter 2");
            cap1.add(new Paragraph("Paragraph 1"));
            cap1.add(new Paragraph("Paragraph 2"));
            cap1.add(new Paragraph("Paragraph 3"));

            cap11.add(new ImageProxy("ImageOne"));
            cap11.add(new Image("ImageTwo"));

            cap2.add(new Paragraph("Paragraph 4"));
            //cap2.add(p4);
            cap1.add(cap11);
            cap1.add(new Paragraph("Some text"));
            cap1.add(new Table("Table 1"));
            b.addContent(cap1);
            b.addContent(cap2);


            TableOfContentUpdate tocUpdate = new TableOfContentUpdate();
            b.accept(tocUpdate);
            System.out.println("______________");
            tocUpdate.getToC().accept(new RenderContentVisitor());

        //    b.accept(new RenderContentVisitor());
        }


    public static void main(String[] args) {
// Run this main function and inspect the output console
// to learn about
// the lifecycle of objects within
// Spring Dependency Injection Context
//
// Gets a handle of dependency injection context
        ApplicationContext context =
                (ApplicationContext) SpringApplication.run(SpLabEugenMicleaApplication.class, args);
// Gets an instance of TransientComponent from the DI context
        TransientComponent transientBean =
                context.getBean(TransientComponent.class);
        transientBean.operation();
// Note that every time an instance is required,
// the DI context creates a new one
        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();
// Gets an instance of SingletonComponent from the DI context
// Note that the unique instance was created while
// application was loaded, before creating
// the transient instances
        SingletonComponent singletonBean =
                context.getBean(SingletonComponent.class);
        singletonBean.operation();
// Note that every time an instance is required,
// the DI returns the same unique one
        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();
// Gets an instance of another class that
// requires singleton/transient components
// Note where this instance was created and what beans
// were used to initialize it
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();
// One can also request an instance from DI context by name
        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();

        createTableOfContent();
    }



}
  

