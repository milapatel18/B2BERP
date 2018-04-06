package com.b2berp.b2brepository;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author milap.patel
 */
public class CreateDAOANDIMPL {

    public static String domainPath = "ktpl.ecommerce.domain.order";
    public static String daoPath = "com.b2berp.b2brepository.dao";
    public static String daoImplPath = "com.b2berp.b2brepository.dao.impl";
    public static String servicePath = "ktpl.ecommerce.data.service";
    public static String serviceImplPath = "ktpl.ecommerce.data.service.impl";
    public static String baseDir = "C:\\Users\\Milap Patel\\Documents\\J2EEeCommerce\\B2BERP\\B2BMODEL\\src\\main\\java\\com\\b2berp\\b2bmodel\\core";
    public static String daoDir = "D:\\Project\\Development2Copy\\Ecommerce\\src\\main\\java\\ktpl\\ecommerce\\dao";
    public static String daoImplDir = "D:\\Project\\Development2Copy\\Ecommerce\\src\\main\\java\\ktpl\\ecommerce\\dao\\impl";
    public static String serviceDir = "D:\\Project\\Development2Copy\\Ecommerce\\src\\main\\java\\ktpl\\ecommerce\\data\\service";
    public static String serviceImplDir = "D:\\Project\\Development2Copy\\Ecommerce\\src\\main\\java\\ktpl\\ecommerce\\data\\service\\impl";

    public static void main(String[] args) throws IOException {
        //createDAO();
        //reateDAOImpl();
        createDAOss();
        //createServiceImpl();
    }/**
     * get mapping for hibernates
     * @throws IOException 
     */
    public static void createDAOss() throws IOException {
        File f = new File(baseDir);
        if (f.exists()) {
            if (f.isDirectory()) {
                for (File domainFile : f.listFiles()) {
                    System.out.println("<mapping class=\"com.b2berp.b2bmodel.core."+domainFile.getName().replace(".java", "")+"\"></mapping>");
                   

                }
            }
        }
    }

    public static void createDAO() throws IOException {
        File f = new File(baseDir);
        if (f.exists()) {
            if (f.isDirectory()) {
                for (File domainFile : f.listFiles()) {
                    File daoFile = new File(daoDir + "\\" + domainFile.getName().replace(".java", "DAO.java"));
                    if (!daoFile.exists()) {
                        try {
                            daoFile.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(CreateDAOANDIMPL.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        continue;
                    }
                    FileWriter fw = new FileWriter(daoFile.getAbsoluteFile());

                    String content = "package " + daoPath + ";";
                    content += "\n import " + domainPath + "." + domainFile.getName().replace(".java", ";");
                    content += "\n public interface " + daoFile.getName().replace(".java", "") + " extends GenericDao<" + domainFile.getName().replace(".java", "") + ", Long>{} ";
                    content += "";
                    content += "";
                    content += "";

                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(content);
                    bw.close();
                    //break;

                }
            }
        }
    }

    public static void createDAOImpl() throws IOException {
        File f = new File(baseDir);
        if (f.exists()) {
            if (f.isDirectory()) {
                for (File domainFile : f.listFiles()) {
                    File daoImplFile = new File(daoImplDir + "\\" + domainFile.getName().replace(".java", "DAOImpl.java"));
                    if (!daoImplFile.exists()) {
                        try {
                            daoImplFile.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(CreateDAOANDIMPL.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        continue;
                    }
                    FileWriter fw = new FileWriter(daoImplFile.getAbsoluteFile());

                    String daoName = domainFile.getName().replace(".java", "DAO");
                    String repositoryName = domainFile.getName().replace(".java", "DAO").substring(0, 1).toLowerCase();
                    repositoryName += domainFile.getName().replace(".java", "DAO").substring(1);

                    String content = "package " + daoImplPath + ";";
                    content += "\n import " + daoPath + "." + daoName + ";";
                    content += "\n import " + domainPath + "." + domainFile.getName().replace(".java", ";");
                    content += "\n import org.springframework.stereotype.Repository;";
                    content += "\n @Repository(\"" + repositoryName + "\") \n public class " + daoName + "Impl extends GenericDaoImpl<" + domainFile.getName().replace(".java", "") + ", Long>  implements " + daoName + "{\n} ";
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(content);
                    bw.close();
                    //break;

                }
            }
        }
    }

    public static void createServices() throws IOException {
        File f = new File(baseDir);
        if (f.exists()) {
            if (f.isDirectory()) {
                for (File domainFile : f.listFiles()) {
                    File serviceFile = new File(serviceDir + "\\" + domainFile.getName().replace(".java", "Service.java"));
                    if (!serviceFile.exists()) {
                        try {
                            serviceFile.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(CreateDAOANDIMPL.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        continue;
                    }
                    FileWriter fw = new FileWriter(serviceFile.getAbsoluteFile());

                    String content = "package " + servicePath + ";";
                    content += "\n import " + domainPath + "." + domainFile.getName().replace(".java", ";");
                    content += "\n public interface " + serviceFile.getName().replace(".java", "") + " extends GenericService<" + domainFile.getName().replace(".java", "") + ", Long>{} ";

                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(content);
                    bw.close();
                   // break;

                }
            }
        }
    }

    public static void createServiceImpl() throws IOException {
        File f = new File(baseDir);
        if (f.exists()) {
            if (f.isDirectory()) {
                for (File domainFile : f.listFiles()) {
                    File serviceImplFile = new File(serviceImplDir + "\\" + domainFile.getName().replace(".java", "ServiceImpl.java"));
                    if (!serviceImplFile.exists()) {
                        try {
                            serviceImplFile.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(CreateDAOANDIMPL.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        continue;
                    }
                    FileWriter fw = new FileWriter(serviceImplFile.getAbsoluteFile());

                    String daoName = domainFile.getName().replace(".java", "DAO");
                    String serviceName = domainFile.getName().replace(".java", "Service");
                    String serviceAnnonationName = serviceName.substring(0, 1).toLowerCase();
                    serviceAnnonationName += serviceName.substring(1);
                    String daoVarName = daoName.substring(0, 1).toLowerCase();
                    daoVarName += daoName.substring(1);

                    String content = "package " + serviceImplPath + ";";
                    content += "\n import " + daoPath + "." + daoName + ";";
                    content += "\n import " + servicePath + "." + serviceName + ";";
                    content += "\n import " + domainPath + "." + domainFile.getName().replace(".java", ";");
                    content += "\n import ktpl.ecommerce.dao.GenericDao;";
                    content += "\n import org.springframework.stereotype.Service;";
                    content += "\n import org.springframework.beans.factory.annotation.Qualifier;";
                    content += "\n import org.springframework.beans.factory.annotation.Autowired;";
                    content += "\n @Service(\"" + serviceAnnonationName + "\") \n public class " + serviceName + "Impl extends GenericServiceImpl<" + domainFile.getName().replace(".java", "") + ", Long>  implements " + serviceName + "{";
                    content += "\n private "+daoName+" "+daoVarName+";";
                    content += "\n public "+serviceName+"Impl(){}";
                    content += "\n\n @Autowired\npublic "+serviceName+"Impl(@Qualifier(\""+daoVarName+"\")GenericDao<"+ domainFile.getName().replace(".java", "") + ", Long> genericDao){";
                    content += "\n super(genericDao);";
                    content += "\n this."+daoVarName+" = ("+daoName+") genericDao;";
                    content += "\n }";
                    content += "\n }";
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(content);
                    bw.close();
                   // break;

                }
            }
        }
    }

}
