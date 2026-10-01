package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

    private ArrayList<Maquina> maquinas;

    public NegocioMejorado() {
        this.maquinas = new ArrayList<Maquina>();
    }

    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public String generarCodigo() {
        int numero = (int) (Math.random() * 100) + 1; // número entre 1 y 100
        return "M-" + numero;
    }

    // Ya incluye la validación de duplicados (punto 7)
    public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
        String codigo = generarCodigo();

        // Si ya existe una máquina con ese código → duplicado
        if (recuperarMaquina(codigo) != null) {
            return false;
        }

        Maquina maquina = new Maquina(nombreCerveza, descripcion, precioPorMl, codigo);
        maquinas.add(maquina);
        return true;
    }

    public void cargarMaquinas() {
        for (int i = 0; i < maquinas.size(); i++) {
            maquinas.get(i).llenarMaquina();
        }
    }

    public Maquina recuperarMaquina(String codigo) {
        Maquina encontrada = null;
        for (int i = 0; i < maquinas.size(); i++) {
            Maquina m = maquinas.get(i);
            if (m.getCodigo().equals(codigo)) { // ¡con equals(), no con ==!
                encontrada = m;
            }
        }
        return encontrada;
    }
}