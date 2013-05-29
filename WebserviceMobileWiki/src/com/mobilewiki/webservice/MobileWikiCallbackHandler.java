
/**
 * MobileWikiCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.mobilewiki.webservice;

    /**
     *  MobileWikiCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MobileWikiCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MobileWikiCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MobileWikiCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getTitleForArticleId method
            * override this method for handling normal response from getTitleForArticleId operation
            */
           public void receiveResultgetTitleForArticleId(
                    com.mobilewiki.webservice.MobileWikiStub.GetTitleForArticleIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTitleForArticleId operation
           */
            public void receiveErrorgetTitleForArticleId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for respondMessage method
            * override this method for handling normal response from respondMessage operation
            */
           public void receiveResultrespondMessage(
                    com.mobilewiki.webservice.MobileWikiStub.RespondMessageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from respondMessage operation
           */
            public void receiveErrorrespondMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDateChangeForContentId method
            * override this method for handling normal response from getDateChangeForContentId operation
            */
           public void receiveResultgetDateChangeForContentId(
                    com.mobilewiki.webservice.MobileWikiStub.GetDateChangeForContentIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDateChangeForContentId operation
           */
            public void receiveErrorgetDateChangeForContentId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getContentForContentId method
            * override this method for handling normal response from getContentForContentId operation
            */
           public void receiveResultgetContentForContentId(
                    com.mobilewiki.webservice.MobileWikiStub.GetContentForContentIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getContentForContentId operation
           */
            public void receiveErrorgetContentForContentId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTagForContentId method
            * override this method for handling normal response from getTagForContentId operation
            */
           public void receiveResultgetTagForContentId(
                    com.mobilewiki.webservice.MobileWikiStub.GetTagForContentIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTagForContentId operation
           */
            public void receiveErrorgetTagForContentId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getContentIdsforArticleId method
            * override this method for handling normal response from getContentIdsforArticleId operation
            */
           public void receiveResultgetContentIdsforArticleId(
                    com.mobilewiki.webservice.MobileWikiStub.GetContentIdsforArticleIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getContentIdsforArticleId operation
           */
            public void receiveErrorgetContentIdsforArticleId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getArticleIds method
            * override this method for handling normal response from getArticleIds operation
            */
           public void receiveResultgetArticleIds(
                    com.mobilewiki.webservice.MobileWikiStub.GetArticleIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getArticleIds operation
           */
            public void receiveErrorgetArticleIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getArticleIdForContentId method
            * override this method for handling normal response from getArticleIdForContentId operation
            */
           public void receiveResultgetArticleIdForContentId(
                    com.mobilewiki.webservice.MobileWikiStub.GetArticleIdForContentIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getArticleIdForContentId operation
           */
            public void receiveErrorgetArticleIdForContentId(java.lang.Exception e) {
            }
                


    }
    