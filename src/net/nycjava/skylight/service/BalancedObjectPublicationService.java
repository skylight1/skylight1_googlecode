package net.nycjava.skylight.service;

public interface BalancedObjectPublicationService extends Observable<BalancedObjectObserver> {
	void applyForce(float anAngleInRadians, float aForceInNewtons);
}