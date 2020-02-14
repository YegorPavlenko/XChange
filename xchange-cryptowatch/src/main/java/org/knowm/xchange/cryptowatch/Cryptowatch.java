package org.knowm.xchange.cryptowatch;

import org.knowm.xchange.cryptowatch.dto.marketdata.results.CryptowatchAssetPairsResult;
import org.knowm.xchange.cryptowatch.dto.marketdata.results.CryptowatchAssetsResult;
import org.knowm.xchange.cryptowatch.dto.marketdata.results.CryptowatchOHLCResult;
import org.knowm.xchange.cryptowatch.dto.marketdata.results.CryptowatchOrderBookResult;
import org.knowm.xchange.cryptowatch.dto.marketdata.results.CryptowatchPriceResult;
import org.knowm.xchange.cryptowatch.dto.marketdata.results.CryptowatchSummaryResult;
import org.knowm.xchange.cryptowatch.dto.marketdata.results.CryptowatchTradesResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/** @@author massi.gerardi */
@Path("0")
@Produces(MediaType.APPLICATION_JSON)
public interface Cryptowatch {

  @GET
  @Path("markets/{market}/{pair}/ohlc")
  CryptowatchOHLCResult getOHLC(
      @PathParam("market") String market,
      @PathParam("pair") String pair,
      @QueryParam("before") long before,
      @QueryParam("after") long after,
      @QueryParam("periods") int periods);

  @GET
  @Path("markets/{market}/{pair}/price")
  CryptowatchPriceResult getPrice(
      @PathParam("market") String market, @PathParam("pair") String pair);

  @GET
  @Path("markets/{market}/{pair}/summary")
  CryptowatchSummaryResult getTicker(
      @PathParam("market") String market, @PathParam("pair") String pair);

  @GET
  @Path("markets/{market}/{pair}/trades")
  CryptowatchTradesResult getTrades(
      @PathParam("market") String market,
      @PathParam("pair") String pair,
      @QueryParam("limit") Integer limit,
      @QueryParam("since") long since);

  @GET
  @Path("markets/{market}/{pair}/orderbook")
  CryptowatchOrderBookResult getOrderBook(
      @PathParam("market") String market, @PathParam("pair") String pair);

  @GET
  @Path("assets")
  CryptowatchAssetsResult getAssets();

  @GET
  @Path("pairs")
  CryptowatchAssetPairsResult getAssetPairs();
}