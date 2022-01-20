package me.banto.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.banto.tp.model.Metrics;

/**
 * @author Antoine BALIEU
 */
@Repository
public interface MetricsRepository extends JpaRepository<Metrics, Integer>{

    default Metrics get() {
        if (!existsById(1)) {
            Metrics metrics = new Metrics();
            metrics.setCounter(0);
            return save(metrics);
        }

        return getById(1);
    }
}
