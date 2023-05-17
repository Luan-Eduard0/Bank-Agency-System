/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario.view.Table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luan
 */
public abstract class AbstractTable <D> extends AbstractTableModel {

    private List<D> registros = new ArrayList<>();
    private final String[] colunas;

    public AbstractTable(String... colunas) {
        this.colunas = colunas;
    }
    
    
    
    
    @Override
    public int getRowCount() {
      return registros.size();   
    }

    @Override
    public int getColumnCount() {
     return colunas.length;
    }

    public List<D> getRegistros() {
        return registros;
    }

    public void setRegistros(List<D> registros) {
        this.registros = registros;
        fireTableDataChanged();
    }
    public void addRegistro(D registro){
        this.registros.add(registro);
        fireTableDataChanged();
        
        
        
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
      return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
}
