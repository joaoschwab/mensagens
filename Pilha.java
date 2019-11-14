/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author PUCPR
 */
public class Pilha {
    

    private ArrayList<String> dados = new ArrayList<String>();
    

    public void empilha(String valor){
        this.dados.add(valor);
    }

    public ArrayList getPilha(){
        return dados;
    }
    public void clear(){
        this.dados.clear();
    }
    
    
}
