
% 2015-10-17 01:04:22

% my_logs\longTest1\0_0_1\rep_18\priority_log.m
scheduling_duration_us = 2055;

% schedule
schedule_f_t_n(:,:,1) = [5, 0; 5, 0; 5, 0; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 0, 0; 0, 0];

% cost function results
vioSt = [0];
vioDl = [0];
vioNon = [2277];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [0];
vioLcy = [7280];
vioJit = [12845];
cost_vio = 246422;
cost_switches = 400;
cost_ch = 800;
costTotal = 247622;

% priority
% 
% ############### Network 0 ##############
% F0	|[0]5	|5	|5	|	|	|	|	|	|	|	|[10]	|	|	|5	|5	|5	|5	|5	|5	|5	|[20]5	|5	|5	|	|	|
% ############### Network 1 ##############
% F0	|[0]	|	|	|5	|5	|5	|5	|5	|5	|5	|[10]5	|5	|5	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
