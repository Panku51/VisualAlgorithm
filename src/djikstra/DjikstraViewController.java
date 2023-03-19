package djikstra;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//Took ALert syntax from https://www.geeksforgeeks.org/javafx-alert-with-examples/
//https://www.tutorialspoint.com/javafx/javafx_path_transition.htm
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.animation.PathTransition;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.util.Scanner;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import java.io.File;
import java.util.*;

class vertices{
  String name;
  int x,y,w;
  String name1, name2;
  vertices(String name,int x,int y){
      this.name=name;
      this.x=x;
      this.y=y;

  }



}
class Edges{

  String name1, name2;
  int w;
  Edges(String name1, String name2, int w)
  {
      this.name1=name1;
      this.name2=name2;
      this.w=w;
  }
}
/*
class adj{
  vertices obj;
  ArrayList<vertices> down = new ArrayList<vertices>();
  adj(vertices obj){
      this.obj = obj;
  }
}*/
class invalidedge extends Exception
{
  String message;
  invalidedge(String message)
  {
      this.message=message;
  }

  public void printEx()
  {
      Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning Dialog");
          alert.setHeaderText(message);
          alert.setContentText("Provide input");

          alert.showAndWait();
      //System.out.println(message);

  }
}
public class DjikstraViewController {
  @FXML
  TextField t1, t2, t3, t4, t5, t6, t7, t8, t10, t11, t9, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23;
  @FXML
  TextArea a1;
  @FXML
  DialogPane d1;
  @FXML
  AnchorPane ac1;
  
  @FXML
  void openExplore(ActionEvent event) {
	  Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/djikstra/dijkstra.fxml"));
		// OR
//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

  }
  
  @FXML
  void OpenSample(ActionEvent event) {
	  Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/djikstra/SampleCase.fxml"));
		// OR
//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }


  @FXML
  void openVisualize(ActionEvent event) {
	  Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/djikstra/DjikstraView.fxml"));
		// OR
//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

  }


  int w=0, size=2000;
 // String arrString[]={"a", "b", "c", "d", "e", "f", "g", "h", "i"};
  ArrayList<String> vert = new ArrayList<String>();
  ArrayList<vertices> list = new ArrayList<vertices>();
  ArrayList<Edges> adj[] = new ArrayList[size];
//
////  for(i=0; i<size; i++)
////  {
////      adj[i]=new ArrayList<vertices>();
////  }
///*
//  public void mouse(MouseEvent evt)
//  {
//  try {
////      Circle alpha = new Circle(, Color.RED);
//      int x, y;
////      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
////          // public void handle(MouseEvent me) {
//      x = (int) evt.getX();
//
//      y = (int) evt.getY();
//
////          //}
////      };
//      Circle circle = new Circle();
//      String s = arrString[w++];
//      vertices v = new vertices(s, x, y);
//      int index = vert.indexOf(s);
//      if (index < 0) {
//          vert.add(s);
//          index = vert.indexOf(s);
//          adj[index] = new ArrayList<Edges>();
//          list.add(v);
//
//          a1.setText("Vertex added successfully");
//      } else {
//          throw new invalidedge("Vertex name already exists");
////          }
////              a1.setText("Vertex already exists");
//      }
//      circle.setCenterX(x);
//      circle.setCenterY(y);
//      circle.setRadius(10);
//
//      circle.setFill(Color.CORAL);
//      ac1.getChildren().add(circle);
//
//
//      System.out.println("Mouse entered");
//  }
//  catch(invalidedge obj)
//  {
//      obj.printEx();
//  }
//  }*/
///*
//  public void mousedrag(MouseEvent evt)
//  {
//      try {
////      Circle alpha = new Circle(, Color.RED);
//          int x, y;
//       //   evt.getX()
////      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
////          // public void handle(MouseEvent me) {
//          x = (int) evt.getX();
//
//          y = (int) evt.getY();
//          for(int m=0; m<list.size())
//
////          //}
////      };
//          if (index < 0) {
//              vert.add(s);
//              index = vert.indexOf(s);
//              adj[index] = new ArrayList<Edges>();
//              list.add(v);
//
//              a1.setText("Vertex added successfully");
//          } else {
//              throw new invalidedge("Vertex name already exists");
////          }
////              a1.setText("Vertex already exists");
//          }
//          circle.setCenterX(x);
//          circle.setCenterY(y);
//          circle.setRadius(10);
//
//          circle.setFill(Color.CORAL);
//          ac1.getChildren().add(circle);
//
//
//          System.out.println("Mouse entered");
//      }
//      catch(invalidedge obj)
//      {
//          obj.printEx();
//      }
//  }
//*/


  public void Addvertex(ActionEvent E) {
      try {
          String s = t1.getText();
          if(s==null || s.isEmpty())
              throw new invalidedge("Invalid input");
          int x = Integer.parseInt(t2.getText());
          int y = Integer.parseInt(t3.getText());

//          if(isInteger)


          Circle circle = new Circle();
          circle.setCenterX(x*5);
          circle.setCenterY(y*5);
          circle.setRadius(10);

          circle.setFill(Color.CORAL);
          ac1.getChildren().add(circle);
          vertices v = new vertices(s, x, y);
          int index = vert.indexOf(s);
          if (index < 0) {
              vert.add(s);
              index = vert.indexOf(s);
              adj[index] = new ArrayList<Edges>();
              list.add(v);

              a1.setText("Vertex added successfully");
          } else {
                      throw new invalidedge("Vertex name already exists");
//          }
//              a1.setText("Vertex already exists");
          }

     }

      catch(NumberFormatException e){
         // obj.printEx();
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning Dialog");
          alert.setHeaderText("Enter appropriate inputs");
          alert.setContentText("");

          alert.showAndWait();
         // a1.setText("Error");
      }
      catch(invalidedge obj)
      {
          obj.printEx();
      }

  }

  public void searchVertex(ActionEvent E) {
      try{
      String str = t4.getText();
      if(str==null || str.isEmpty())
          throw new invalidedge("Invalid input");
      int index = vert.indexOf(str);

          if (index < 0) {
              a1.setText("Vertex not found");

          } else {
              int k = 0, flag = 0;
              while (flag == 0 && k < list.size()) {
                  String name1 = list.get(k).name;
                  if (name1.equalsIgnoreCase(str)) {
                      String out = list.get(k).name + " " + list.get(k).x + " " + list.get(k).y;
                      a1.setText(out);
                      flag = 1;
                  }
                  k++;
              }

          }
      }
      catch(invalidedge obj)
      {
          obj.printEx();
      }
  }


  public void deleteVertex(ActionEvent E) {
      try {
          String str = t5.getText();
          if (str == null || str.isEmpty())
              throw new invalidedge("Invalid input");
          int index = vert.indexOf(str);
          if (index < 0) {
              a1.setText("Vertex not found");

          } else {

              for(int m=0; m<list.size(); m++)
              {
                  String stemp=list.get(m).name;


                  int ind1= vert.indexOf(stemp);
                  int  p = 0;
                  while (p < adj[ind1].size())// && flag==0)
                  {

                      System.out.println("Edge : " + adj[ind1].get(p).name1+ " " +adj[ind1].get(p).name2 );
                      if (adj[ind1].get(p).name2.equalsIgnoreCase(str) || adj[ind1].get(p).name1.equalsIgnoreCase(str))
                      {
                          System.out.println("Deletingg" + adj[ind1].get(p).name1 + " " + adj[ind1].get(p).name2);
                          a1.setText("Edge found and deleted");//

                          adj[ind1].remove(p);

                          //flag = 1;
                      }
                      else
                      p++;
                  }
              }
              int k = 0, flag = 0;
              while (flag == 0 || k < list.size()) {
                  String name1 = list.get(k).name;

                  if (name1.equalsIgnoreCase(str)) {
                      int x = list.get(k).x;
                      int y = list.get(k).y;
                      vert.remove(str);
                      String out = "Vertex found and deleted";
                      a1.setText(out);
                      list.remove(k);
                      flag = 1;
//          if(isInteger)
                  }
                      ac1.getChildren().clear();
                      for(int l=0; l<list.size(); l++)
                      {
                          int x1 = list.get(l).x;
                          int y1 = list.get(l).y;
                          Circle circle = new Circle();
                          circle.setCenterX(x1*5);
                          circle.setCenterY(y1*5);
                          circle.setRadius(10);

                          circle.setFill(Color.ROYALBLUE);
                          ac1.getChildren().add(circle);
                      }
                      for(int n=0; n<list.size(); n++) {
                          String stemp = list.get(n).name;


                          int ind1 = vert.indexOf(stemp);
                          int p = 0;
                          while (p < adj[ind1].size())// && flag==0)
                          {

                              String Vf=adj[ind1].get(p).name1;
                              String Vt=adj[ind1].get(p).name2;
                              int x1=-1, y1=-1, x2=-1, y2=-1;
                              for(int m=0; m<list.size();  m++)
                              {
                                  if(list.get(m).name.equalsIgnoreCase(Vf))
                                  {
                                      x1=list.get(m).x;
                                      y1=list.get(m).y;
                                  }
                                  if(list.get(m).name.equalsIgnoreCase(Vt))
                                  {
                                      x2=list.get(m).x;
                                      y2=list.get(m).y;
                                  }
                              }

                              Line line = new Line();
                              line.setStartX(x1*5);
                              line.setStartY(y1*5);
                              line.setEndX(x2*5);
                              line.setEndY(y2*5);
                              line.setStroke(Color.DARKMAGENTA);
                              line.setStrokeWidth(3);
                              ac1.getChildren().add(line);
                              p++;
                                  //flag = 1;
                          }


                      }



                  k++;


                  a1.setText("Vertex Found and Deleted");//






//
              }



          }
      }
      catch(invalidedge obj)
      {
          obj.printEx();
      }
  }


  public void modifyVertex(ActionEvent E) {
      try {
          String str = t6.getText();
          if (str == null || str.isEmpty())
              throw new invalidedge("Invalid input");
          int x = Integer.parseInt(t7.getText());
          int y = Integer.parseInt(t8.getText());

          int index = vert.indexOf(str);
          if (index < 0) {
              a1.setText("Vertex not found");

          } else {
              int k = 0, flag = 0;
              while (flag == 0 || k < list.size()) {
                  String name1 = list.get(k).name;
                  if (name1.equalsIgnoreCase(str)) {
                      list.get(k).x = x;
                      list.get(k).y = y;
                      String out = "Vertex found and modified";
                      a1.setText(out);

                      flag = 1;
                  }
                  k++;
              }

          }
      }
      catch(invalidedge obj)
      {
          obj.printEx();
      }
  }

  public void addEdge(ActionEvent E) {
      try {
          String Vfrom = t9.getText();
          String Vto = t10.getText();
          int weight = Integer.parseInt(t11.getText());
          if (Vfrom == null || Vfrom.isEmpty())
              throw new invalidedge("Invalid input");
          if (Vto == null || Vto.isEmpty())
              throw new invalidedge("Invalid input");
          int ind1 = vert.indexOf(Vfrom);
          int x1=-1,y1=-1,x2=-1,y2=-1;
          for(int m=0; m<list.size();  m++)
          {
              if(list.get(m).name.equalsIgnoreCase(Vfrom))
              {
                  x1=list.get(m).x;
                  y1=list.get(m).y;
              }
              if(list.get(m).name.equalsIgnoreCase(Vto))
              {
                  x2=list.get(m).x;
                  y2=list.get(m).y;
              }
          }
          int ind2 = vert.indexOf(Vto);
          if (ind1 < 0 || ind2 < 0) {

                  throw new invalidedge("Invalid vertices");
            //  a1.setText("Invalid vertices");
          } else {

              Edges v1 = new Edges(Vfrom, Vto, weight);
              adj[ind1].add(v1);
              Line line = new Line();
              line.setStartX(x1*5);
              line.setStartY(y1*5);
              line.setEndX(x2*5);
              line.setEndY(y2*5);
              line.setStroke(Color.DARKMAGENTA);
              line.setStrokeWidth(3);
              ac1.getChildren().add(line);
//          x= list.get(ind2).x;
//           y= list.get(ind2).y;
//              Edges v2 = new Edges(Vto, Vfrom, weight);
//              adj[ind2].add(v2);
              a1.setText("Edge added successfully");


          }
      }
      catch(invalidedge obj)
      {
          obj.printEx();
      }
      catch(NumberFormatException e)
      {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning Dialog");
          alert.setHeaderText("Enter appropriate inputs");
          alert.setContentText("");

          alert.showAndWait();
      }
  }

  public void searchEdge(ActionEvent E) {
      try {
          String Vfrom = t12.getText();
          String Vto = t13.getText();
          if (Vfrom == null || Vfrom.isEmpty())
              throw new invalidedge("Invalid input");
          if (Vto == null || Vto.isEmpty())
              throw new invalidedge("Invalid input");
          int ind1 = vert.indexOf(Vfrom);
          int ind2 = vert.indexOf(Vto);
          if (ind1 < 0 || ind2 < 0) {
              throw new invalidedge("Incorrect vertex/vertices");
             // a1.setText("Vertex one of them doesn't exist");
          } else {
              int flag = 0, p = 0;
              while (p < adj[ind1].size())// && flag==0)
              {
                  if (adj[ind1].get(p).name2.equalsIgnoreCase(Vto)) {
                      a1.setText("Edge found : " + adj[ind1].get(p).name1 + " " + adj[ind1].get(p).name2 + " " + adj[ind1].get(p).w);
                      flag = 1;
                  }
                  p++;
              }
              if (flag == 0) {
                  a1.setText("Edge not found");
              }
          }
      }
      catch(invalidedge obj){
          obj.printEx();
      }

  }

  public void deleteEdge(ActionEvent E) {
      try{
      String Vfrom = t14.getText();
      String Vto = t15.getText();
      if (Vfrom == null || Vfrom.isEmpty())
          throw new invalidedge("Invalid input");
      if (Vto == null || Vto.isEmpty())
          throw new invalidedge("Invalid input");
      int ind1 = vert.indexOf(Vfrom);
      int ind2 = vert.indexOf(Vto);

      if (ind1 < 0 || ind2 < 0) {
          throw new invalidedge("Incorrect vertex/vertices");
          //a1.setText("Vertex one of them doesn't exist");
      } else {
          int flag = 0, p = 0;
          a1.setText("validdd");//
          while (p < adj[ind1].size())// && flag==0)
          {
              if (adj[ind1].get(p).name2.equalsIgnoreCase(Vto)) {
                  a1.setText("Edge found and deleted");//

                  adj[ind1].remove(p);
                  flag = 1;
              }
              p++;
          }
//
                    ac1.getChildren().clear();
                      for(int l=0; l<list.size(); l++)
                      {
                          int x1 = list.get(l).x;
                          int y1 = list.get(l).y;
                          Circle circle = new Circle();
                          circle.setCenterX(x1*5);
                          circle.setCenterY(y1*5);
                          circle.setRadius(10);

                          circle.setFill(Color.ROYALBLUE);
                          ac1.getChildren().add(circle);
                      }
                      for(int n=0; n<list.size(); n++) {
                          String stemp = list.get(n).name;


                          int indt = vert.indexOf(stemp);
                          int p1 = 0;
                          while (p1 < adj[indt].size())// && flag==0)
                          {

                              String Vf=adj[indt].get(p1).name1;
                              String Vt=adj[indt].get(p1).name2;
                              int x1=-1, y1=-1, x2=-1, y2=-1;
                              for(int m=0; m<list.size();  m++)
                              {
                                  if(list.get(m).name.equalsIgnoreCase(Vf))
                                  {
                                      x1=list.get(m).x;
                                      y1=list.get(m).y;
                                  }
                                  if(list.get(m).name.equalsIgnoreCase(Vt))
                                  {
                                      x2=list.get(m).x;
                                      y2=list.get(m).y;
                                  }
                              }

                              Line line = new Line();
                              line.setStartX(x1*5);
                              line.setStartY(y1*5);
                              line.setEndX(x2*5);
                              line.setEndY(y2*5);
                              line.setStroke(Color.DARKMAGENTA);
                              line.setStrokeWidth(3);
                              ac1.getChildren().add(line);
                              p1++;
                                  //flag = 1;
                          }


                      }
//
//          p = 0;
//          flag = 0;
//          while (p < adj[ind2].size())//&& flag==0)
//          {
//              if (adj[ind2].get(p).name2.equalsIgnoreCase(Vfrom)) {
//                  //a1.setText("Edge found and deleted");//
//                  //a1.setText("Edge found : " + adj[ind2].get(p).name1 + " " + adj[ind2].get(p).name2 + " " + adj[ind2].get(p).w);
//
//                  adj[ind2].remove(p);
//
//                  //a1.setText("Edge  deleted: " + adj[ind1].get(p).name1 + " " + adj[ind1].get(p).name2 + " " + adj[ind1].get(p).w);
////                  adj[ind1].get(i).name2="";
////                  adj[ind1].get(i).w=0;
//                  flag = 1;
//              }
//              p++;
//          }
          if (flag == 0) {
              throw new invalidedge("Edge not found");

          }
      }}
      catch (invalidedge obj)
      {
          obj.printEx();
      }

  }


  public void modifyEdge(ActionEvent E) {
      try {
          String Vfrom = t16.getText();
          String Vto = t17.getText();
          if (Vfrom == null || Vfrom.isEmpty())
              throw new invalidedge("Invalid input");
          if (Vto == null || Vto.isEmpty())
              throw new invalidedge("Invalid input");
          int weight = Integer.parseInt(t18.getText());
          int ind1 = vert.indexOf(Vfrom);
          int ind2 = vert.indexOf(Vto);

          if (ind1 < 0 || ind2 < 0) {
              throw new invalidedge("Incorrect vertex/vertices");
          } else {
              int flag = 0, p = 0;
           //   a1.setText("validdd");//
              while (p < adj[ind1].size()) {
                  if (adj[ind1].get(p).name2.equalsIgnoreCase(Vto)) {
                      a1.setText("Edge found and modified");//
                      //  a1.setText("Edge found : " + adj[ind1].get(p).name1 + " " + adj[ind1].get(p).name2 + " " + adj[ind1].get(p).w);

                      adj[ind1].get(p).w = weight;
                      flag=1;

                      //a1.setText("Edge  deleted: " + adj[ind1].get(p).name1 + " " + adj[ind1].get(p).name2 + " " + adj[ind1].get(p).w);
//                  adj[ind1].get(i).name2="";
//                  adj[ind1].get(i).w=0;

                  }
                  p++;
              }
//              p = 0;
//              flag = 0;
//              while (p < adj[ind2].size() && flag == 0) {
//                  if (adj[ind2].get(p).name2.equalsIgnoreCase(Vfrom)) {
//                      adj[ind2].get(p).w = weight;
//
//                      flag = 1;
//                  }
//                  p++;
//              }
              if (flag == 0) {
                  throw new invalidedge("Edge not found");
              }
          }
      }
      catch(invalidedge obj)
      {
          obj.printEx();
      }
      catch(NumberFormatException e)
      {

          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning Dialog");
          alert.setHeaderText("Enter appropriate inputs");
          alert.setContentText("");

          alert.showAndWait();
      }
  }

  public void readFile(ActionEvent E) throws FileNotFoundException {
      try {
          String path = t19.getText();
          System.out.println(path);
          File file = new File(path);
//      try {
          Scanner sc = new Scanner(file);

          {
              //System.out.println(sc.nextLine());

              int no_v = sc.nextInt();
              sc.nextLine();
              System.out.println(no_v);

              for (int m = 0; m < no_v; m++) {
                  String str = sc.nextLine();
                  String arr[] = str.split(" ");


                  String name = arr[0];
//                  if(name.isEmpty() || name==null )
//                  {
//                      throw new invalidedge("INCORRECT INPUTS");
//                  }
                  if(arr.length!=3)
                  {
                      throw new invalidedge("INCORRECT INPUTS");
                  }
                  if(arr[0].isEmpty() || arr[1].isEmpty() || arr[2].isEmpty() )
                  {
                      throw new invalidedge("INCORRECT INPUTS");
                  }
                  int x1 = Integer.parseInt(arr[1]);
                  int y1 = Integer.parseInt(arr[2]);


                  vertices v = new vertices(name, x1, y1);
                  int index = vert.indexOf(name);
                  if (index < 0) {
                      vert.add(name);
                      System.out.println("vertex added : " + name);
                      index = vert.indexOf(name);
                      adj[index] = new ArrayList<Edges>();
                      list.add(v);
                      Circle circle = new Circle();
                      circle.setCenterX(x1*5);
                      circle.setCenterY(y1*5);
                      circle.setRadius(10);

                      circle.setFill(Color.CORAL);
                      ac1.getChildren().add(circle);
                      //int ind1=
                      //adj obj1 = new adj(v);

                      a1.setText("Vertex added successfully");
                  } else {
                      throw new invalidedge("Vertex already exists");
                  }
//
//              System.out.println(sc.nextLine());
              }
//
//
              int no_E = sc.nextInt();
              sc.nextLine();
              for (int m = 0; m < no_E; m++) {
                  String str = sc.nextLine();
                  String arr[] = str.split(" ");
                  if(arr.length!=3)
                  {
                      throw new invalidedge("INCORRECT INPUTS");
                  }
                  String Vfrom = arr[0];
                  String Vto = arr[1];
                  int weight = Integer.parseInt(arr[2]);
                  int x1=-1,y1=-1,x2=-1,y2=-1;
                  for(int r=0; r<list.size();  r++)
                  {
                      if(list.get(r).name.equalsIgnoreCase(Vfrom))
                      {
                          x1=list.get(r).x;
                          y1=list.get(r).y;
                      }
                      if(list.get(r).name.equalsIgnoreCase(Vto))
                      {
                          x2=list.get(r).x;
                          y2=list.get(r).y;
                      }
                  }
                  int ind1 = vert.indexOf(Vfrom);
                  int ind2 = vert.indexOf(Vto);
                  if (ind1 < 0 || ind2 < 0) {
                      throw new invalidedge("Incorrect vertex/vertices");
                  } else {

                      Edges v1 = new Edges(Vfrom, Vto, weight);
                      adj[ind1].add(v1);
//                      Edges v2 = new Edges(Vto, Vfrom, weight);
//                      adj[ind2].add(v2);
//                      Edges v1 = new Edges(Vfrom, Vto, weight);
//                      adj[ind1].add(v1);
                    //  int ind1 = vert.indexOf(Vfrom);

                      Line line = new Line();
                      line.setStartX(x1*5);
                      line.setStartY(y1*5);
                      line.setEndX(x2*5);
                      line.setEndY(y2*5);
                      line.setStroke(Color.DARKMAGENTA);
                      line.setStrokeWidth(3);
                      ac1.getChildren().add(line);
                      a1.setText("Edge added successfully");
                  }

              }
          }

      }
      catch(invalidedge obj)
      {
          obj.printEx();
      }
      catch(FileNotFoundException f)
      {

          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning Dialog");
          alert.setHeaderText("FILE NOT FOUND");
          alert.setContentText("");

          alert.showAndWait();
      }
  }


  public void writeFile(ActionEvent E) throws IOException,  FileNotFoundException {
      try {
          String path = t20.getText();
          System.out.println(path);

          FileWriter fw = new FileWriter(path);

          // read character wise from string and write
          // into FileWriter
          Collections.sort(list, new Comparator<vertices>() {
              @Override
              public int compare(vertices o1, vertices o2) {
                  return o1.name.compareTo(o2.name);
              }
          });
          //System.out.println("");
          fw.write(list.size());
          String size=list.size()+"\n";
         fw.write(size);
          for (int m = 0; m < list.size(); m++) {
              System.out.println("hereee in output" + list.get(m).name);
              String str = list.get(m).name + " " + list.get(m).x + " " + list.get(m).y + "\n";
              System.out.println(list.get(m).name + " " + list.get(m).x + " " + list.get(m).y + "\n");
              //for (int i = 0; i < str.length(); i++)
                  fw.write(str);
          }

          ArrayList<String> Copy = new ArrayList<String>(vert);
          Collections.sort(Copy);
//          Collections.sort(vert, new Comparator<String>() {
//              @Override
//              public int compare(String o1, String o2) {
//                  return o1.compareTo(o2);
//              }
//          });
          int no_edges=0;
          for (int p = 0; p < vert.size(); p++) {
              int indsort=vert.indexOf(Copy.get(p));
              for (int m = 0; m < adj[indsort].size(); m++)
              {
               no_edges++;
              }


          }
          fw.write(no_edges + "\n");
          for (int p = 0; p < vert.size(); p++) {
                  int indsort=vert.indexOf(Copy.get(p));
              Collections.sort(adj[indsort], new Comparator<Edges>() {
                  @Override
                  public int compare(Edges o1, Edges o2) {
                      return o1.name1.compareTo(o2.name1);
                  }
              });
              Collections.sort(adj[indsort], new Comparator<Edges>() {
                  @Override
                  public int compare(Edges o1, Edges o2) {
                      return o1.name2.compareTo(o2.name2);
                  }
              });

              for (int m = 0; m < adj[indsort].size(); m++)
              {
                  String str = adj[indsort].get(m).name1 + " " + adj[indsort].get(m).name2 + " " + adj[indsort].get(m).w + "\n";
                  for (int i = 0; i < str.length(); i++)
                      fw.write(str.charAt(i));
              }
              }


          a1.setText("Successfully written");
          System.out.println("Writing successful");
          //close the file
          fw.close();

//      }
//      catch(invalidedge obj)
//      {
//          obj.printEx();
//      }
      }
      catch(FileNotFoundException e)
      {

          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning Dialog");
          alert.setHeaderText("FILE NOT FOUND");
          alert.setContentText("");

          alert.showAndWait();
      }




  }


  public void getPath(ActionEvent E)
  {
      try {
          String Vcurr = t21.getText();
          String Vend = t22.getText();
          if (Vcurr == null || Vcurr.isEmpty())
              throw new invalidedge("Invalid input");
          if (Vend == null || Vend.isEmpty())
              throw new invalidedge("Invalid input");
          int ind1 = vert.indexOf(Vcurr);
          int ind2 = vert.indexOf(Vend);
        //  System.out.println(Vcurr + "   " + Vend);
          if (ind1 < 0 || ind2 < 0) {
              throw new invalidedge("Incorrect vertex/vertices");
          } else {
              Map<String, Integer> hash1 = new HashMap<String, Integer>();
              for (int j = 0; j < vert.size(); j++) {
                  hash1.put(vert.get(j), j);
              }
              int[] parent = new int[9999999];
              double[] distance = new double[+999999];
              int[] set = new int[1000000];
              Map<Integer, String> mp = new HashMap<Integer, String>();
              for (int i1 = 0; i1 < vert.size(); i1++) {
                  distance[i1] = 99999999.9;
                  parent[i1] = -1;
                  set[i1] = 0;
              }

              int sr = hash1.get(Vcurr);
              distance[sr] = 0.0;

              for (int i1 = 0; i1 < vert.size(); i1++) {

                  double mindist = 9999999.9;
                  int min_i = sr;
                  for (int i2 = 0; i2 < vert.size(); i2++) {
                      if (set[i2] == 0 && distance[i2] <= mindist) {
                          mindist = distance[i2];
                          min_i = i2;
                      }
                  }
                  int u = min_i;
                  set[u] = 1;
                  for (int r = 0; r < adj[u].size(); r++)
                  {
                      String to = adj[u].get(r).name2;
                      int to_i = hash1.get(to);


                      if (set[to_i] == 0 && distance[u] + adj[u].get(r).w < distance[to_i])
                      {
                          distance[to_i] = distance[u] + adj[u].get(r).w;
                          parent[to_i] = u;
                          mp.put(to_i, adj[u].get(r).name1);
                      }

                  }

              }

              int temp = hash1.get(Vend);
              if (Double.compare(distance[temp], 99999999.9) == 0) {
                  System.out.println("no path exists");
              } else if (Vend.equalsIgnoreCase(Vcurr)) {
                  System.out.println("source on landmark");
              }
              else {
                  ArrayList<String> printPath = new ArrayList<String>();

                  while (true) {
                      int temp1 = parent[temp];
                                //  System.out.println("no of vertices : " +  vert.size());

                      for (int p = 0; p < vert.size(); p++) {
                          for (int r = 0; r < adj[p].size(); r++) {
                              if (adj[p].get(r).name1.equalsIgnoreCase(mp.get(temp)) && hash1.get(adj[p].get(r).name1) == temp1 && hash1.get(adj[p].get(r).name2) == temp)
                              {

                                  String stemp =adj[p].get(r).name2;
                                  System.out.println(stemp+ " ");
                                  printPath.add(stemp);
                                  //adj[p].get(r).name1 + " " +
                              }
                          }
                      }
                     // printPath.add(Vcurr);
                      temp = parent[temp];
                      if (temp1 == sr)
                          break;

                  }
                  String stemp = "";
                      printPath.add(Vcurr);
                  for (int p = printPath.size() - 1; p >= 0; p--)
                  {
                      //System.out.println("IDHARRRR");
                      stemp += printPath.get(p) + " ";
                      // System.out.println(printPath.get(p));
                  }
                  a1.setText(stemp);

                  String prefShape=t23.getText();
                  String vName;
                  int x1=-1,y1=-1;
                  for(int m=0; m<list.size();  m++) {
                      if (list.get(m).name.equalsIgnoreCase(Vcurr)) {
                          x1 = list.get(m).x;
                          y1 = list.get(m).y;
                         // a1.setText("PATH TSARTED");
                         // System.out.println("X : "+ x1 + "  Y "+ y1);
                      }
                  }
                  if(prefShape.equalsIgnoreCase("circle")) {
                      Circle shape = new Circle();

                      //Setting the position of the circle
                      shape.setCenterX(20);
                      shape.setCenterY(20);

                      //Setting the radius of the circle
                      shape.setRadius(20);

                      //Setting the color of the circle
                      shape.setFill(Color.BROWN);
                      ac1.getChildren().add(shape);

                      //Setting the stroke width of the circle
                      shape.setStrokeWidth(20);


                      //Creating a Path
                      Path path = new Path();
                      MoveTo moveTo = new MoveTo(x1*5, y1*5);
                      path.getElements().add(moveTo);
                      //Moving to the starting point


                      int k = 0;
                      for (int p = printPath.size() - 1; p >= 0; p--) {
                          String vTemp = printPath.get(p);
                          //    System.out.println("Vtemp : " + vTemp);
                          int m = 0, f = 0;
                          //System.out.println(list.size());
                          while (m < list.size() && f == 0) {
                              String s = list.get(m).name;
//                          System.out.println(s);
//                          System.out.println("Vtemp : " + vTemp);
                              if (s.equalsIgnoreCase(vTemp)) {
                                  //  System.out.println("FOUND");
                                  int x2 = list.get(m).x;
                                  int y2 = list.get(m).y;
                                  LineTo line1 = new LineTo(x2*5, y2*5 );

                                //  System.out.println("name : " + vTemp + " X : " + x2 + "  Y " + y2);
                                  f = 1;

                                  path.getElements().add(line1);
                                  //MoveTo moveTo = new MoveTo(x2,y2);
                                  // k++;
                              }
                              m++;
                          }


                      }


                      PathTransition pathTransition = new PathTransition();

                      //Setting the duration of the transition
                      pathTransition.setDuration(Duration.millis(1000));

                      //Setting the node for the transition
                      pathTransition.setNode(shape);

                      //Setting the path for the transition
                      pathTransition.setPath(path);

                      //Setting the orientation of the path

                      //Setting the cycle count for the transition
                      pathTransition.setCycleCount(20);

                      //Setting auto reverse value to true
                      // pathTransition.setAutoReverse(false);

                      //Playing the animation
                      pathTransition.play();
                  }
                  else if(prefShape.equalsIgnoreCase("square")) {

                      Rectangle shape = new Rectangle();
//                      Rectangle r = new Rectangle();
                      shape.setX(50);
                      shape.setY(50);
                      shape.setWidth(20);
                      shape.setHeight(20);
                      shape.setArcWidth(2);
                      shape.setArcHeight(2);
                      //Setting the position of the circle
//                      shape.setCenterX(20);
//                      shape.setCenterY(20);

                      //Setting the radius of the circle
//                      shape.setRadius(20);

                      //Setting the color of the circle
                      shape.setFill(Color.FORESTGREEN);
                      ac1.getChildren().add(shape);

                      //Setting the stroke width of the circle
                      shape.setStrokeWidth(20);

                      Path path = new Path();
                      MoveTo moveTo = new MoveTo(x1*5, y1*5);
                      path.getElements().add(moveTo);
                      //Moving to the starting point


                      int k = 0;
                      for (int p = printPath.size() - 1; p >= 0; p--) {
                          String vTemp = printPath.get(p);
                          //    System.out.println("Vtemp : " + vTemp);
                          int m = 0, f = 0;
                          //System.out.println(list.size());
                          while (m < list.size() && f == 0) {
                              String s = list.get(m).name;
//                          System.out.println(s);
//                          System.out.println("Vtemp : " + vTemp);
                              if (s.equalsIgnoreCase(vTemp)) {
                                  //  System.out.println("FOUND");
                                  int x2 = list.get(m).x;
                                  int y2 = list.get(m).y;
                                  LineTo line1 = new LineTo(x2*5 , y2*5 );

                                  //System.out.println("name : " + vTemp + " X : " + x2 + "  Y " + y2);
                                  f = 1;

                                  path.getElements().add(line1);
                                  //MoveTo moveTo = new MoveTo(x2,y2);
                                  // k++;
                              }
                              m++;
                          }


                      }


                      PathTransition pathTransition = new PathTransition();

                      //Setting the duration of the transition
                      pathTransition.setDuration(Duration.millis(1000));

                      //Setting the node for the transition
                      pathTransition.setNode(shape);

                      //Setting the path for the transition
                      pathTransition.setPath(path);

                      //Setting the orientation of the path

                      //Setting the cycle count for the transition
                      pathTransition.setCycleCount(20);

                      //Setting auto reverse value to true
                      // pathTransition.setAutoReverse(false);

                      //Playing the animation
                      pathTransition.play();



                  }

                  else if(prefShape.equalsIgnoreCase("triangle")) {


                      Polygon shape = new Polygon();
                      shape.getPoints().addAll(new Double[]{
                              -10.0, 0.0, 10.0, 10.0,
                              20.0, 0.0});

//                      shape.setLayoutX(20.0);
//                      shape.setLayoutY(20.0);

//                      Rectangle r = new Rectangle();

                      //Setting the position of the circle
//                      shape.setCenterX(20);
//                      shape.setCenterY(20);

                      //Setting the radius of the circle
//                      shape.setRadius(20);

                      //Setting the color of the circle
                      shape.setFill(Color.OLIVE);
                      ac1.getChildren().add(shape);

                      //Setting the stroke width of the circle
                      shape.setStrokeWidth(20);

                      Path path = new Path();
                      MoveTo moveTo = new MoveTo(x1*5, y1*5);
                      path.getElements().add(moveTo);
                      //Moving to the starting point


                      int k = 0;
                      for (int p = printPath.size() - 1; p >= 0; p--) {
                          String vTemp = printPath.get(p);
                          //    System.out.println("Vtemp : " + vTemp);
                          int m = 0, f = 0;
                          //System.out.println(list.size());
                          while (m < list.size() && f == 0) {
                              String s = list.get(m).name;
//                          System.out.println(s);
//                          System.out.println("Vtemp : " + vTemp);
                              if (s.equalsIgnoreCase(vTemp)) {
                                  //  System.out.println("FOUND");
                                  int x2 = list.get(m).x;
                                  int y2 = list.get(m).y;
                                  LineTo line1 = new LineTo(x2*5, y2*5 );

                                  System.out.println("name : " + vTemp + " X : " + x2 + "  Y " + y2);
                                  f = 1;

                                  path.getElements().add(line1);
                                  //MoveTo moveTo = new MoveTo(x2,y2);
                                  // k++;
                              }
                              m++;
                          }


                      }


                      PathTransition pathTransition = new PathTransition();

                      //Setting the duration of the transition
                      pathTransition.setDuration(Duration.millis(1000));

                      //Setting the node for the transition
                      pathTransition.setNode(shape);

                      //Setting the path for the transition
                      pathTransition.setPath(path);

                      //Setting the orientation of the path

                      //Setting the cycle count for the transition
                      pathTransition.setCycleCount(200);

                      //Setting auto reverse value to true
                      // pathTransition.setAutoReverse(false);

                      //Playing the animation
                      pathTransition.play();



                  }

                  else if(prefShape.equalsIgnoreCase("plus")) {

                      Line line3 = new Line(20, 20, 40, 20);
                      Line line4 = new Line(30,30,30,10);
                      line3.setStroke(Color.AQUA);
                      line4.setStroke(Color.AQUA);
                      line3.setStrokeWidth(5);
                      line4.setStrokeWidth(5);
                      Group shape=new Group();
                      shape.getChildren().addAll(line3, line4);

                      //Polyline shape = new Polyline();
//                      shape.getPoints().addAll(new Double[]{
//
//                             });

//                      shape.setLayoutX(20.0);
//                      shape.setLayoutY(20.0);

//                      Rectangle r = new Rectangle();

                      //Setting the position of the circle
//                      shape.setCenterX(20);
//                      shape.setCenterY(20);

                      //Setting the radius of the circle
//                      shape.setRadius(20);

                      //Setting the color of the circle
//                      shape.setFill(Color.BLACK);
                      ac1.getChildren().add(shape);

                      //Setting the stroke width of the circle
                      //shape.setStrokeWidth(20);

                      Path path = new Path();
                      MoveTo moveTo = new MoveTo(x1*5, y1*5);
                      path.getElements().add(moveTo);
                      //Moving to the starting point


                      int k = 0;
                      for (int p = printPath.size() - 1; p >= 0; p--) {
                          String vTemp = printPath.get(p);
                          //    System.out.println("Vtemp : " + vTemp);
                          int m = 0, f = 0;
                          //System.out.println(list.size());
                          while (m < list.size() && f == 0) {
                              String s = list.get(m).name;
//                          System.out.println(s);
//                          System.out.println("Vtemp : " + vTemp);
                              if (s.equalsIgnoreCase(vTemp)) {
                                  //  System.out.println("FOUND");
                                  int x2 = list.get(m).x;
                                  int y2 = list.get(m).y;
                                  LineTo line1 = new LineTo(x2*5 , y2*5 );

                                  System.out.println("name : " + vTemp + " X : " + x2 + "  Y " + y2);
                                  f = 1;

                                  path.getElements().add(line1);
                                  //MoveTo moveTo = new MoveTo(x2,y2);
                                  // k++;
                              }
                              m++;
                          }


                      }


                      PathTransition pathTransition = new PathTransition();

                      //Setting the duration of the transition
                      pathTransition.setDuration(Duration.millis(1000));

                      //Setting the node for the transition
                      pathTransition.setNode(shape);

                      //Setting the path for the transition
                      pathTransition.setPath(path);

                      //Setting the orientation of the path

                      //Setting the cycle count for the transition
                      pathTransition.setCycleCount(200);

                      //Setting auto reverse value to true
                      // pathTransition.setAutoReverse(false);

                      //Playing the animation
                      pathTransition.play();



                  }


                  else if(prefShape.equalsIgnoreCase("cross")) {

                      Line line3 = new Line(20, 20,40,40 );
                      Line line4 = new Line(20, 40,40,20);
                      line3.setStroke(Color.TAN);
                      line4.setStroke(Color.TAN);
                      line3.setStrokeWidth(5);
                      line4.setStrokeWidth(5);
                      Group shape=new Group();
                      shape.getChildren().addAll(line3, line4);

                      //Polyline shape = new Polyline();
//                      shape.getPoints().addAll(new Double[]{
//
//                             });

//                      shape.setLayoutX(20.0);
//                      shape.setLayoutY(20.0);

//                      Rectangle r = new Rectangle();

                      //Setting the position of the circle
//                      shape.setCenterX(20);
//                      shape.setCenterY(20);

                      //Setting the radius of the circle
//                      shape.setRadius(20);

                      //Setting the color of the circle
//                      shape.setFill(Color.BLACK);
                      ac1.getChildren().add(shape);

                      //Setting the stroke width of the circle
                      //shape.setStrokeWidth(20);

                      Path path = new Path();
                      MoveTo moveTo = new MoveTo(x1*5, y1*5);
                      path.getElements().add(moveTo);
                      //Moving to the starting point


                      int k = 0;
                      for (int p = printPath.size() - 1; p >= 0; p--) {
                          String vTemp = printPath.get(p);
                          //    System.out.println("Vtemp : " + vTemp);
                          int m = 0, f = 0;
                          //System.out.println(list.size());
                          while (m < list.size() && f == 0) {
                              String s = list.get(m).name;
//                          System.out.println(s);
//                          System.out.println("Vtemp : " + vTemp);
                              if (s.equalsIgnoreCase(vTemp)) {
                                  //  System.out.println("FOUND");
                                  int x2 = list.get(m).x;
                                  int y2 = list.get(m).y;
                                  LineTo line1 = new LineTo(x2*5 , y2*5 );

                                  System.out.println("name : " + vTemp + " X : " + x2 + "  Y " + y2);
                                  f = 1;

                                  path.getElements().add(line1);
                                  //MoveTo moveTo = new MoveTo(x2,y2);
                                  // k++;
                              }
                              m++;
                          }


                      }


                      PathTransition pathTransition = new PathTransition();

                      //Setting the duration of the transition
                      pathTransition.setDuration(Duration.millis(1000));

                      //Setting the node for the transition
                      pathTransition.setNode(shape);

                      //Setting the path for the transition
                      pathTransition.setPath(path);

                      //Setting the orientation of the path

                      //Setting the cycle count for the transition
                      pathTransition.setCycleCount(200);

                      //Setting auto reverse value to true
                      // pathTransition.setAutoReverse(false);

                      //Playing the animation
                      pathTransition.play();



                  }
              }

          }


      }
      catch(invalidedge obj)
      {
          obj.printEx();
      }


  }



}