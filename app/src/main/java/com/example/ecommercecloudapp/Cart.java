
package com.example.ecommercecloudapp;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;
import com.backendless.geo.GeoPoint;

import java.util.List;
import java.util.Date;

public class Cart
{
  private String ownerId;
  private String objectId;
  private Date updated;
  private Date created;
  private String quantity;
  private String url;
  private String price;
  private String Name;
  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public Date getCreated()
  {
    return created;
  }

  public String getQuantity()
  {
    return quantity;
  }

  public void setQuantity( String quantity )
  {
    this.quantity = quantity;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl( String url )
  {
    this.url = url;
  }

  public String getPrice()
  {
    return price;
  }

  public void setPrice( String price )
  {
    this.price = price;
  }

  public String getName()
  {
    return Name;
  }

  public void setName( String Name )
  {
    this.Name = Name;
  }

                                                    
  public Cart save()
  {
    return Backendless.Data.of( Cart.class ).save( this );
  }

  public void saveAsync( AsyncCallback<Cart> callback )
  {
    Backendless.Data.of( Cart.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Cart.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Cart.class ).remove( this, callback );
  }

  public static Cart findById( String id )
  {
    return Backendless.Data.of( Cart.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<Cart> callback )
  {
    Backendless.Data.of( Cart.class ).findById( id, callback );
  }

  public static Cart findFirst()
  {
    return Backendless.Data.of( Cart.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<Cart> callback )
  {
    Backendless.Data.of( Cart.class ).findFirst( callback );
  }

  public static Cart findLast()
  {
    return Backendless.Data.of( Cart.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<Cart> callback )
  {
    Backendless.Data.of( Cart.class ).findLast( callback );
  }

  public static List<Cart> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( Cart.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<Cart>> callback )
  {
    Backendless.Data.of( Cart.class ).find( queryBuilder, callback );
  }
}