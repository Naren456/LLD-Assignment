package com.example.reports;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report  {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();

    private static Map<String, Report> cache = new HashMap<>();


    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        // Starter placeholder: intentionally incorrect.
       String cacheKey = reportId + "|" + title + "|" + classification;

		if (cache.containsKey(cacheKey)) {
			cache.get(cacheKey).display(user);
		} else {
			if (accessControl.canAccess(user, classification)) {
				RealReport realReport = new RealReport(reportId, title, classification);
				cache.put(cacheKey, realReport);
				realReport.display(user);
			} else {
				System.out.println("User " + user.getName() + " with role " + user.getRole()
						+ " does not have priveleges to access this report. Report Classification: " + classification);
			}
		}
    }

}
