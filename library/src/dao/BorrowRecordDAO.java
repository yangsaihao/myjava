package dao;

import java.util.List;

import model.BorrowRecord;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BorrowRecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.BorrowRecord
 * @author MyEclipse Persistence Tools
 */
public class BorrowRecordDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BorrowRecordDAO.class);
	// property constants
	public static final String BOOK_ID = "bookId";
	public static final String BORROWER_ID = "borrowerId";

	public void save(BorrowRecord transientInstance) {
		log.debug("saving BorrowRecord instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BorrowRecord persistentInstance) {
		log.debug("deleting BorrowRecord instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BorrowRecord findById(java.lang.String id) {
		log.debug("getting BorrowRecord instance with id: " + id);
		try {
			BorrowRecord instance = (BorrowRecord) getSession().get(
					"model.BorrowRecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BorrowRecord instance) {
		log.debug("finding BorrowRecord instance by example");
		try {
			List results = getSession().createCriteria("model.BorrowRecord")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BorrowRecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BorrowRecord as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBookId(Object bookId) {
		return findByProperty(BOOK_ID, bookId);
	}

	public List findByBorrowerId(Object borrowerId) {
		return findByProperty(BORROWER_ID, borrowerId);
	}

	public List findAll() {
		log.debug("finding all BorrowRecord instances");
		try {
			String queryString = "from BorrowRecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BorrowRecord merge(BorrowRecord detachedInstance) {
		log.debug("merging BorrowRecord instance");
		try {
			BorrowRecord result = (BorrowRecord) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BorrowRecord instance) {
		log.debug("attaching dirty BorrowRecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BorrowRecord instance) {
		log.debug("attaching clean BorrowRecord instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}