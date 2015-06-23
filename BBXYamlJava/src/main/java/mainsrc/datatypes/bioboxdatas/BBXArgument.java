/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc.datatypes.bioboxdatas;

import java.util.ArrayList;

/**
 *
 * @author Mark
 */
public class BBXArgument{
    
    private String name;
    private ArrayList <BBXDataField> datas;
    private StringBuilder strB;
    
    public BBXArgument(String id){
        this.name = id;
        this.datas = new <BBXDataField>ArrayList();
        this.strB = new StringBuilder();
    }
    
    public void addData(String name, String value){
        this.datas.add(new BBXDataField(name, value));
    }
    
    public void addData(BBXDataField field){
        this.datas.add(field);
    }
    
    /**
     * Generates a substring for this argument.
     * @return the .yaml-compatible substring for this argument
     */
    public String getString(){
        this.strB = new StringBuilder();
        String n = System.getProperty("line.separator");
        this.strB.append(" - ");
        this.strB.append(this.getName());
        this.strB.append(":");
        this.strB.append(n);
        this.strB.append("   - ");
        for (BBXDataField b: this.datas){
            this.strB.append(b.getString());
            this.strB.append(n);
            this.strB.append("     ");
        }
        return this.strB.toString();
    }

    /**
     * @return name of the argument
     */
    public String getName() {
        return name;
    }

    public ArrayList <BBXDataField> getDatas() {
        return datas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDatas(ArrayList <BBXDataField> datas) {
        this.datas = datas;
    }
    
    public void clear(){
        this.datas = new <BBXDataField>ArrayList();
    }
    
}
