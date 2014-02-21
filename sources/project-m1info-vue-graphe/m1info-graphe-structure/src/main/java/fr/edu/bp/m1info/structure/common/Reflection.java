/* ==========================================
 * GrapheMultiPlateforme : a free Java graph-theory library
 * ==========================================
 * 
 * salmuz : Carranza Alarcon Yonatan Carlos
 * 
 * (C) Copyright 2013, by salmuz and Contributors.
 * 
 * Project Info:  https://github.com/salmuz/Graphes_Multi_Plateformes
 * Project Creator:  salmuz (https://www.assembla.com/spaces/salmuz-java) 
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc.,
 * 
 * ------------------
 * Point.java
 * ------------------
 * (C) Copyright 2013, by salmuz and Contributors
 *
 * Original Author: Carranza Alarcon Yonatan Carlos
 * Contributor(s):  Coz Velasquez Antonio
 * 					Kalil DAHER MOHAMED
 *                  Aben Nouh Abdirazak 
 *
 * Changes
 * -------
 * 14/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Types;

public class Reflection {

     /**
      *
      * Return the type generic of the class instantiated.
      *
      * The reason make use of the method Class.getGenericSuperClass() is because
      * we will retrieve type information source the current caller instance.
      * The manner of use:
      *   we always must declare the class with anonymous.
      *   ClassParent<Type> object = new SubTypeParent<Type>() { };
      *
      *  @param clazz, the class of parent
      *  @paran indexParam, the index of the types generic
      *
      *  @return class, return the type generic used in the instance.
      */
    public static Class getParamGenericOfSuperCLass(Class clazz, int indexParam) {

        Type superclass = clazz.getGenericSuperclass();

        // sink be necessary validate that it's a class anonymous

        if(superclass instanceof Class){
          throw new RuntimeException("The class must be anonymous.");
        }


        Type []types = ((ParameterizedType) superclass).getActualTypeArguments();

        if ( indexParam > types.length ) {
            throw new RuntimeException(String.format("There is only %d generic parameters ",types.length));
        }

        return getClassOfType(types[indexParam]);

    }

    /**
     * Cet methode permet de tester le type de classe appartient un objet dans ce projet
     *
     * @param type  ceci permet de tester le type quand veut savoir son classe
     *
     * @return   qui est une classe
     */
    public static Class<?> getClassOfType(Type type){
        Class<?> rawType = ( ( type instanceof Class<?> )  ? (Class<?>) type :
                            (Class<?>) ((ParameterizedType) type).getRawType() );

        return rawType;
    }

}
