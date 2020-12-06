package com.example.Client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bluer extends Remote {
    byte[] blurring(byte[] byteOfImage) throws RemoteException;
}
