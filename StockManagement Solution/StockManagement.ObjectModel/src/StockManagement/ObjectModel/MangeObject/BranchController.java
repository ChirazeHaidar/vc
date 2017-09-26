/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IBranch;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Firas
 */
public class BranchController implements IBranch {

    private final SessionFactory _sessionFactory;
    private Session _session;

    public BranchController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }

    @Override
    public Branch get(int brCode) {
        Object objBranch = _session.get(Branch.class, brCode);
        if (null == objBranch) {
            return null;
        }
        return (Branch) objBranch;
    }

    @Override
    public int add(Branch branch) {
        try {
            if (branch.getCompany() == null) {
                throw (new Exception("Company is not set.."));
            }
            Transaction tx = _session.beginTransaction();
            _session.save(branch);
            tx.commit();
            return branch.getBrCode();
        } catch (Exception e) {
            //throw(e);
        } finally {
            /* if (!_sessionFactory.isClosed()) {
                _sessionFactory.close();
            }*/
            return -1;
        }
    }

    @Override
    public int add(int compCode, Branch branch) {
        try {
            Object objCompany = _session.get(Company.class, compCode);
            if (null == objCompany) {
                return -1;
            }

            branch.setCompany((Company) objCompany);
            Transaction tx = _session.beginTransaction();
            _session.save(branch);
            tx.commit();
            return branch.getBrCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(Branch branch) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.delete(branch);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(int brCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Branch where BrCode= " + brCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean update(Branch branch) {
        try {
            if (branch.getCompany() == null) {
                return false;
            }
            Transaction tx = _session.beginTransaction();

            _session.update(branch);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean assignRole(RoleBranch roleBranch) {
        try {
            if (null == roleBranch
                    || null == roleBranch.getBranch()
                    || null == roleBranch.getRole()) {
                return false;
            }
            Transaction tx = _session.beginTransaction();
            _session.save(roleBranch);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }

    }

    @Override
    public boolean assignRole(int brCode, int roCode) {
        try {
            List<RoleBranch> rbList= _session.createQuery("from RoleBranch RB where RB.role.roCode = "+roCode+" and RB.branch.brCode =" + brCode).list();
            if ( rbList != null && rbList.size()>0)
                return true;
            RoleController controller = new RoleController();
            Role role = controller.get(roCode);
            Branch branch = get(brCode);
            
            if (null == role || null == branch) {
                return false;
            }
            RoleBranch roleBranch = new RoleBranch();
            roleBranch.setRole(role);
            roleBranch.setBranch(branch);
            Transaction tx = _session.beginTransaction();
            _session.save(roleBranch);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<Role> getRoles(Branch branch) {
        List<Role> roles = _session.createQuery("select R from Role R,RoleBranch RB where R.roCode = RB.role.roCode and RB.branch.brCode =" + branch.getBrCode()).list();
        if (null == roles || roles.isEmpty()) {
            return null;
        }
        return roles;
    }

    @Override
    public List<Role> getRoles(int brCode) {
        List<Role> roles = _session.createQuery("select R from Role R,RoleBranch RB where R.roCode = RB.role.roCode and RB.branch.brCode = " + brCode).list();
        if (null == roles || roles.isEmpty()) {
            return null;
        }
        return roles;
    }

    @Override
    public List<Role> getExcludedRoles(int brCode) {
        List<Role> roles = _session.createQuery("select R from Role R where R.roCode not in( select RB.role.roCode from RoleBranch RB where RB.branch.brCode = " + brCode + ")").list();
        if (null == roles || roles.isEmpty()) {
            return null;
        }
        return roles;
    }

    @Override
    public boolean removeRole(RoleBranch roleBranch) {
        try {
            return removeRole(roleBranch.getBranch().getBrCode(), roleBranch.getRole().getRoCode());
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean removeRole(int brCode, int roCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from RoleBranch RB where RB.branch.brCode= " + brCode + " and RB.role.roCode = " + roCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }
}
